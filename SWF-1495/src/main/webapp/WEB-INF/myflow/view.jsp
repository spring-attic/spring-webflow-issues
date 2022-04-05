<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Flow Page</title>
</head>
<body>
  <h1>My Flow Page</h1>
  <hr>
  <form:form action="${flowExecutionUrl}" modelAttribute="myModel" method="post">
    <c:forEach items="${myModel.options}" var="option">
       <form:checkbox path="selected" value="${option}" id="selected${option}" />
       <label for="selected${option}">${option}</label>
    </c:forEach>
    <button type="submit" name="_eventId_continue">End Flow</button>
  </form:form>
</body>
</html>