<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Course</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div>
			<h1><c:out value="${course.name}"/> with <c:out value="${course.user.userName}"/></h1>
			<a href="/courses">Back to Home</a>
		</div>
		<div>
			<p>Day: <c:out value="${course.weekday}"/></p>
			<p>Cost: $<c:out value="${course.price}"/></p>
			<p>Time: <c:out value="${course.time}"/></p>
			<p><c:out value="${course.description}"/></p>
		</div>
	</div>
</body>
</html>