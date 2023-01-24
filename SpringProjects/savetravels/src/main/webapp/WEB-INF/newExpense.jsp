<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Form</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<div class="container">
		<h1>Add an expense:</h1>
		<form:form action="/expenses/process" method="post" modelAttribute="expense">
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