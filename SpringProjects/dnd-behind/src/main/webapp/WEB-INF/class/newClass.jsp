<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Class</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div>
			<div class="d-flex align-items-center justify-content-between">
				<h1>Create a Class</h1>
				<a href="/campaigns">Back to home</a>
			</div>
		</div>
		<div>
			<form:form action="/classes/create" method="POST" modelAttribute="class">
				<form:input type="hidden" value="${user_id}" path="user" />
				<div class="form-group">
					<label>Name</label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Description</label>
					<form:input path="description" class="form-control"/>
					<form:errors path="description" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Hit Die</label>
					<form:input path="hitDie" class="form-control"/>
					<form:errors path="hitDie" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Primary Ability</label>
					<form:input path="mainAbility" class="form-control"/>
					<form:errors path="mainAbility" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Saving Throw Proficiencies</label>
					<form:input path="saveThrowProf" class="form-control"/>
					<form:errors path="saveThrowProf" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Armor and Weapon Proficiencies</label>
					<form:input path="armorAndWeapons" class="form-control"/>
					<form:errors path="armorAndWeapons" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Skill Proficiencies</label>
					<form:input path="skillProf" class="form-control"/>
					<form:errors path="skillProf" class="text-danger"/>
				</div>
				<div class="d-flex">
					<input type="submit" value="Submit" class="btn btn-primary mt-4" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>