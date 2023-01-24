<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1 class="blue-text">Save Travels</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Expense</th>
					<th scope="col">Vendor</th>
					<th scope="col">Amount</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${allExpenses}">
					<tr>
						<td><a href="/expenses/one/${expense.id}"><c:out value="${expense.name}"/></a></td>
						<td><c:out value="${expense.vendor}"/></td>
						<td>$<c:out value="${expense.amount}"/></td>
						<td class="d-flex">
							<div class="px-2">
								<a class="btn btn-info" href="/expenses/edit/${expense.id}">Edit</a>
							</div>
							<div class="px-2">
								<form action="/expenses/${expense.id}" method="post">
		    					<input type="hidden" name="_method" value="delete">
		    					<input class="btn btn-danger" type="submit" value="Delete">
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<h1 class="blue-text">Add an Expense:</h1>
		<form:form action="/expenses/all" method="post" modelAttribute="expense">
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