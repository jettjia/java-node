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
		// 往session域对象中添加属性
		session.setAttribute("name", "jett");
		// 替换session域对象中属性
		session.setAttribute("name", "jettjia");
		// 删除session域对象中属性
		session.removeAttribute("name");
	%>
</body>
</html>