<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib
	uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Phone Numbers</title>
</head>
<body>
  <h1>Instructions</h1>
  The model validates that the phone numbers are not empty and are equal.
  The 'not empty' validation occurs on the fields, and the errors are reported under 'All errors'
  and by the 'field'.
  <br/>
  The 'do phone numbers match' validation is a object level validation. The error message appears unde 'All errors'
  but NOT, as expected, under 'Object level error'.
 
 <br/>The javadoc for the ErrorsTag says
  <ol>
 	<li>Field only - set '<code>path</code>' to the field name (or path)</li>
 	<li>Object errors only - omit '<code>path</code>'</li>
 	<li>All errors - set '<code>path</code>' to '<code>*</code>'</li>
  </ol>
 
  <h1>Phone Numbers</h1>
  <hr>
 <form:form method="post" modelAttribute="phoneForm">
					<p style="padding-bottom: 20px">Enter your personal information
						below.</p>
						
					<div class="txtErrorMessage">
					<p>All errors</p>
						<!--  show all errors -->
						<form:errors path="*"/>
					</div>
					<div class="txtErrorMessage">
					<p>Object level error</p>
						<!--  show object level errors -->
						<form:errors/>
					</div>
					<div>
						<form:label path="phone1">Phone number</form:label>
						<span style="color: #f00">*</span>
					</div>
					<div>
						<form:input path="phone1" name="phone1" aria-required="true" />
					</div>
					<div class="txtErrorMessage">
						<form:errors path="phone1" />
					</div>
					<br />
					<div>
						<form:label path="phone2">Repeat phone</form:label>
												<span style="color: #f00">*</span>
						
					</div>
					<div>
						<form:input path="phone2" name="phone2" />
					</div>
					<div class="txtErrorMessage">
						<form:errors path="phone2" />
					</div>
					<button  name="_eventId_continue" type="submit"
						id="continueBtn">continue</button>
				</form:form>
</body>
</html>