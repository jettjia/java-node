package com.jettjia.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo01 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 增：创建cookie对象，cookie格式：key=value
		Cookie cookie = new Cookie("key", "value");

		// 查：获取客户端带过来的cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				response.getWriter().write(c.getName() + "=" + c.getValue());
			}
		}

		// 设置cookie过期时间，单位秒
		cookie.setMaxAge(60 * 60); // 1小时

		// Cookie机制中，是通过path来控制权限的。只有<url-pattern>和该path相同或是它的子路径的servlet才能够访问该cookie
		// 如果把一个cookie的path设为项目根目录，那么该项目下的所有servlet都能够访问它
		cookie.setPath(request.getContextPath());// 该路径是: /项目名

		// 用于指定只有请求了指定的域名，才会带上该cookie
		cookie.setDomain(".jettjia.com");
		
		// 删除cookie, 0及是删除
		//cookie.setMaxAge(0); 

		// 向客户端发送cookie
		response.addCookie(cookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
