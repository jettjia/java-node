package com.jettjia.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jettjia.dao.StuDao;
import com.jettjia.dao.UserDao;
import com.jettjia.dao.impl.StuDaoImpl;
import com.jettjia.dao.impl.UserDaoImpl;
import com.jettjia.domain.Student;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 查询数据库
		UserDao dao = new UserDaoImpl();
		boolean isSuccess = dao.login(username, password);
		if (isSuccess) {
			// 获取所有的学生列表
			StuDao stu = new StuDaoImpl();
			List<Student> stuList = stu.findAll();
			
			// 将学生列表集合写入作用于中
			request.getSession().setAttribute("stuList", stuList);
			response.sendRedirect("stu_list.jsp");
		} else {
			response.getWriter().write("账号或密码错误");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
