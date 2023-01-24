<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Ninjas in Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<div class="container text-center">
		<h1><c:out value="${dojo.name}"/></h1>
	</div>
	<div class="container">
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">First Name</th>
		      <th scope="col">Last Name</th>
		      <th scope="col">Age</th>
		    
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="ninja" items="${dojo.ninjas}" >
			    <tr>
			      <td><c:out value="${ninja.firstName}"/></td>
			      <td><c:out value="${ninja.lastName}"/></td>
			      <td><c:out value="${ninja.age}"/></td>
			    </tr>
			</c:forEach>
		   </tbody>
		</table>		
	</div>
</body>
</html>