<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Race</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div>
			<div class="d-flex align-items-center justify-content-between">
				<h1>Create a Race</h1>
				<a href="/campaigns">Back to home</a>
			</div>
		</div>
		<div>
			<form:form action="/races/create" method="POST" modelAttribute="race">
				<form:input type="hidden" value="${user_id}" path="user" />
				<div class="form-group">
					<label>Name</label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Speed</label>
					<form:input path="speed" class="form-control"/>
					<form:errors path="speed" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Ability Bonus</label>
					<form:input path="abilityBonus" class="form-control"/>
					<form:errors path="abilityBonus" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Age</label>
					<form:input path="age" class="form-control"/>
					<form:errors path="age" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Size</label>
					<form:input path="size" class="form-control"/>
					<form:errors path="size" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Languages</label>
					<form:input path="languages" class="form-control"/>
					<form:errors path="languages" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Abilities</label>
					<form:input path="abilities" class="form-control"/>
					<form:errors path="abilities" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Traits</label>
					<form:input path="traits" class="form-control"/>
					<form:errors path="traits" class="text-danger"/>
				</div>
				<div class="d-flex">
					<input type="submit" value="Submit" class="btn btn-primary mt-4" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>