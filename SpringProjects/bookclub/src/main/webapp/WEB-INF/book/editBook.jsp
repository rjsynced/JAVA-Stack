<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<form:form action="/books/edit/${book.id}" method="POST" modelAttribute="book">
			<input type="hidden" name="_method" value="PUT" />
			<form:input type="hidden" path="user" />
			<div class="form-group">
				<label>Title</label>
				<form:input path="title" class="form-control"/>
				<form:errors path="title" class="text-danger"/>
			</div>
			<div class="form-group">
				<label>Author</label>
				<form:input path="authorName" class="form-control"/>
				<form:errors path="authorName" class="text-danger"/>
			</div>
			<div class="form-group">
				<label>My Thoughts</label>
				<form:input path="description" class="form-control"/>
				<form:errors path="description" class="text-danger"/>
			</div>
			<input type="submit" value="Edit Book" class="btn btn-primary mt-4" />
		</form:form>
	</div>
</body>
</html>