<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>New Ninja: </h1>
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
				<div class="form-group">
					<form:label path="dojo" >Dojo: </form:label>
					<form:select path="dojo">
						<c:forEach items="${dojos}" var="dojo">
							<form:option value="${dojo}"> ${dojo.name} </form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<form:label path="firstName">First Name:</form:label>
					<form:input type="text" path="firstName" class="form-control"/>
					<form:errors class="text-danger" path="firstName"/>
				</div>
				<div class="form-group">
					<form:label path="lastName">Last Name:</form:label>
					<form:input type="text" path="lastName" class="form-control"/>
					<form:errors class="text-danger" path="lastName"/>
				</div>
				<div class="form-group">
					<form:label path="age">Age:</form:label>
					<form:input type="text" path="age" class="form-control"/>
					<form:errors class="text-danger" path="age"/>
				</div>
				<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>