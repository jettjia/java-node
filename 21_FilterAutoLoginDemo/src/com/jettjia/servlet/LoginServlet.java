package com.jettjia.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jettjia.dao.UserDao;
import com.jettjia.dao.impl.UserDaoImpl;
import com.jettjia.domain.UserBean;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 获取登录提交的数据
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String auto_login = request.getParameter("auto_login");
			UserBean user = new UserBean();
			user.setUsername(username);
			user.setPassword(password);
			
			UserDao dao = new UserDaoImpl();
			UserBean userBean = dao.login(user);
			if (userBean != null) {
				// 勾选自动登录
				if("on".equals(auto_login)) {
					// 发送cookie给客户端
					Cookie cookie = new Cookie("auto_login", username + "#jettjia#" + password);
					cookie.setMaxAge(7*24*60*60);
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
				}
				// 登录成功，进入首页
				request.getSession().setAttribute("userBean", userBean);
				response.sendRedirect("index.jsp");
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
