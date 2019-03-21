<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Phone Numbers</title>
</head>
<body>
  <h1>Phone Numbers</h1>
  <hr>
  <form action="${flowExecutionUrl}" method="post">
    <p>(917) 455-3605</p>
    <p>(347) 219-2216</p>
    <p>
      <button type="submit" name="_eventId_continue">End Flow</button>
    </p>
  </form>
</body>
</html>