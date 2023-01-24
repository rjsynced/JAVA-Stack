<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container p-3">
		<div class="d-flex justify-content-space-between align-items-center">
			<h1>Expense Details</h1>
			<a href="/expenses/all">Home Page</a>
		</div>
		<h4>Expense Name: <c:out value="${oneExpense.name}"/></h4>
		<h4>Expense Description: <c:out value="${oneExpense.description}"/></h4>
		<h4>Vendor: <c:out value="${oneExpense.vendor}"/></h4>
		<h4>Amount Spent: $<c:out value="${oneExpense.amount}"/></h4>
	</div>
</body>
</html>