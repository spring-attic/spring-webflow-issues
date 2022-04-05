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
	<form:form modelAttribute="myBean" method="POST"
		action="${flowExecutionUrl}">
		
		<ul>
					<c:forEach items="${myBean.elements}" varStatus="status">
						<li>							
							<form:input path="elements[${status.index}].a" />
							<form:input path="elements[${status.index}].b" />
						</li>
					</c:forEach>
		</ul>
		
		<p>
			<button type="submit" name="_eventId_continue">Next</button>
		</p>
	</form:form>
</body>
</html>