<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div>
		<div class="d-flex align-items-center justify-content-between">
			<div>
				<h1 class="color-change">Welcome, <c:out value="${loggedInUser.userName}"/>!</h1>
				<p>Books from everyone's shelves:</p>
			</div>
			<div>
				<a href="/users/logout">Logout</a>
				<a href="/books/create">+ Add a book to my shelf!</a>
			</div>
		</div>
		<div class="container">
		<table class="table">
			  <thead>
			    <tr>
			      	<th scope="col">ID</th>
			      	<th scope="col">Title</th>
			      	<th scope="col">Author Name</th>
			      	<th scope="col">My Thoughts</th>
			      	<th scope="col">Posted By</th>
			      	
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="book" items="${allBooks}" >
				    <tr>
				    	<td><c:out value="${book.id}"/></td>
				      	<td><a href="/books/view/${book.id}"><c:out value="${book.title}"/></a></td>
				      	<td><c:out value="${book.authorName}"/></td>
				      	<td><c:out value="${book.description}"/></td>
				      	<td><c:out value="${book.user.userName}"/></td>
				    </tr>
				</c:forEach>
			   </tbody>
			</table>		
		</div>
	</div>
</body>
</html>