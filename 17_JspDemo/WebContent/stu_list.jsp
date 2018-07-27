<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	学生列表
	<table border="1" width="700">
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>性别</td>
			<td>住址</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${stuList}" var="stu">
		<tr align="center">
			<td>${stu.id }</td>
			<td>${stu.name }</td>
			<td>${stu.age }</td>
			<td>${stu.gender }</td>
			<td>${stu.address }</td>
			<td><a href="#">更新</a> <a href="#">删除</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>