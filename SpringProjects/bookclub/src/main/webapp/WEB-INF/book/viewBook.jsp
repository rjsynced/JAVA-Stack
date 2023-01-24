<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View One Book</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div>
			<h1><c:out value="${book.title}"/></h1>
			<a href="/books">back to the shelves</a>
		</div>
		<div>
			<c:if test="${loggedInUser == book.user}">
				<label>You read </label> <label class="color-green"><c:out value="${book.title}"/></label>
				<p>Here are your thoughts: </p>
				<p><c:out value="${book.description}"/></p>
			</c:if>
		</div>
		<div>
			<c:if test="${loggedInUser != book.user}">
				<label class="color-red"><c:out value="${book.user.userName}"/></label> read <label class="color-change"><c:out value="${book.title}"/></label> by <label class="color-green"><c:out value="${book.authorName}"/></label>
				<p>Here are <c:out value="${book.user.userName}"/>'s thoughts: </p>
				<p><c:out value="${book.description}"/></p>
			</c:if>
		</div>
		<div class="d-flex">
			<c:if test="${loggedInUser == book.user}">
				<a class="btn btn-info" href="/books/edit/${book.id}">Edit</a>
				<form action="/books/delete/${book.id}" method="POST">
					<input type="hidden" value="Delete" name="_method" />
					<input class="btn btn-danger" type="submit" value="Delete" />
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>