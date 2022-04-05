<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Flow Page</title>
</head>
<body>
	<h1>My Flow Page</h1>
	<hr>
		<table border="1">
			<thead>
				<tr>
					<td>index</td>
					<td>a</td>
					<td>b</td>
				</tr>
			</thead>
		<c:forEach items="${myBean.elements}" varStatus="status" var="elem">
			<tr>
				<td>${status.index}</td>
				<td>${elem.a}</td>
				<td>${elem.b}</td>
			</tr>	
		</c:forEach>
		</table>
	<a href="${flowExecutionUrl}&_eventId=continue">endFlow</a>
</body>
</html>