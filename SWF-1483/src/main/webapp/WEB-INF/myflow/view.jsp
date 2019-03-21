<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <form action="${flowExecutionUrl}" method="post">
    <p>Name: ${name}</p>
    <p>Address: ${address}</p>
    <p>
      <button type="submit" name="_eventId_continue">Continue</button>
      <button type="submit" name="_eventId_finish">End Flow</button>
    </p>
  </form>
</body>
</html>