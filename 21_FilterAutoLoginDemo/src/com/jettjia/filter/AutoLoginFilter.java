package com.jettjia.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jettjia.dao.UserDao;
import com.jettjia.dao.impl.UserDaoImpl;
import com.jettjia.domain.UserBean;
import com.jettjia.util.CookieUtil;
import com.mysql.fabric.xmlrpc.base.Value;

public class AutoLoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest request = (HttpServletRequest)req;
			HttpServletResponse response = (HttpServletResponse) resp;
			// 判断session中有没有设置的那个userBean
			UserBean userBean = (UserBean)request.getSession().getAttribute("userBean");
			if (userBean != null) { // userBean的session有效
				chain.doFilter(request, response);
			} else { // userBean的session无效
				Cookie[] cookies = request.getCookies();
				Cookie cookie = CookieUtil.findCookie(cookies, "auto_login");
				if (cookies == null) { // 第一次登录
					chain.doFilter(request, response);
				} else { // 不是第一次登录
					// 获取cookie里的值
					String value = cookie.getValue();
					String username = value.split("#jettjia#")[0];
					String password = value.split("#jettjia#")[1];
					
					// 登录
					UserBean user = new UserBean();
					user.setUsername(username);
					user.setPassword(password);
					
					UserDao dao = new UserDaoImpl();
					dao.login(user);
					
					request.getSession().setAttribute("userBean", userBean);
					chain.doFilter(request, response);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
