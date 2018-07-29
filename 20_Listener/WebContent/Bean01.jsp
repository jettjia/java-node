<%@page import="com.jettjia.domain.Bean01"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 将javabean对象绑定到Session中
		session.setAttribute("bean", new Bean01("jettt"));
		// 从Session中删除javabean对象
		session.removeAttribute("bean");
	%>
</body>
</html>