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
	<div class="container">
		<div class="d-flex align-items-center justify-content-between">
			<div>
				<h1 class="color-change">Welcome, <c:out value="${loggedInUser.userName}"/>!</h1>
			</div>
			<div>
				<a href="/users/logout">Logout</a>
				<a href="/courses/create">+ New Course</a>
			</div>
		</div>
		<div class="container">
		<table class="table">
			  <thead>
			    <tr>
			      	<th scope="col">Class Name</th>
			      	<th scope="col">Instructor</th>
			      	<th scope="col">Weekday</th>
			      	<th scope="col">Price</th>
			      	<th scope="col">Time</th>
			      	
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="course" items="${allCourses}" >
				    <tr>
				    	<td><a href="/courses/view/${course.id}"><c:out value="${course.name}"/></a>
				    		<c:if test="${loggedInUser == course.user}">
								<a class="btn btn-info" href="/courses/edit/${course.id}">Edit</a>
							</c:if>
				    	</td>
				      	<td><c:out value="${course.user.userName}"/></td>
				      	<td><c:out value="${course.weekday}"/></td>
				      	<td>$<c:out value="${course.price}"/>
				   
				      	</td>
				      	<td><c:out value="${course.time}"/></td>
				    </tr>
				</c:forEach>
			   </tbody>
			</table>		
		</div>
	</div>
</body>
</html>