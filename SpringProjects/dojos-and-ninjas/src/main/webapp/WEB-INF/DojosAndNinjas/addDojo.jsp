<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<div class="container">
		<h1>New Dojo</h1>
		<form:form action="/dojos/new" method="POST" modelAttribute="dojo">
			<div>
				<form:label path="name">Name: </form:label>
				<form:input type="text" path="name" class="form-control col-4" />
				<form:errors class="text-danger" path="name" />
			</div>
			<input type="submit" value="Create" class="btn btn-info" /> 
		</form:form>
	</div>
</body>
</html>