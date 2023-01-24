<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Save Travels Form</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-space-between align-items-center">
		<h1 class="edit-text">Add an expense:</h1>
		<a href="/expenses/all">Home Page</a>
		</div>
		<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
				<input type="hidden" name="_method" value="put">
				<div class="form-group">
					<form:label path="name">Expense Name:</form:label>
					<form:input type="text" path="name" class="form-control"/>
					<form:errors class="text-danger" path="name"/>
				</div>
				<div class="form-group">
					<form:label path="vendor">Vendor:</form:label>
					<form:input type="text" path="vendor" class="form-control"/>
					<form:errors class="text-danger" path="vendor"/>
				</div>
				<div class="form-group">
					<form:label path="amount">Amount:</form:label>
					<form:input type="text" path="amount" class="form-control"/>
					<form:errors class="text-danger" path="amount"/>
				</div>
				<div class="form-group">
					<form:label path="description">Description:</form:label>
					<form:input type="text" path="description" class="form-control"/>
					<form:errors class="text-danger" path="description"/>
				</div>
				<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>