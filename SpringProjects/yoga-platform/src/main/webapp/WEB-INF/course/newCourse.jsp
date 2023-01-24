<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Course</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div>
			<div class="d-flex align-items-center justify-content-between">
				<h1>Create a Course</h1>
				<a href="/courses">Back to home</a>
			</div>
		</div>
		<div>
			<form:form action="/courses/create" method="POST" modelAttribute="course">
				<form:input type="hidden" value="${user_id}" path="user" />
				<div class="form-group">
					<label>Name</label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Day of Week</label>
					<form:input path="weekday" class="form-control"/>
					<form:errors path="weekday" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Drop-in Price</label>
					<form:input path="price" class="form-control"/>
					<form:errors path="price" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Time</label>
					<form:input path="time" class="form-control"/>
					<form:errors path="time" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Description</label>
					<form:input path="description" class="form-control"/>
					<form:errors path="description" class="text-danger"/>
				</div>
				<div class="d-flex">
					<input type="submit" value="Submit" class="btn btn-primary mt-4" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>