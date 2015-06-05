<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Flow Page</title>
</head>
<body>
  <h1>My Flow Page (View 1)</h1>
  <hr>
  <form action="${flowExecutionUrl}" method="post">
    <p>Paragraph 1</p>
    <p>Paragraph 2</p>
    <p>
      <button type="submit" name="_eventId_continue">Continue</button>
    </p>
  </form>
</body>
</html>