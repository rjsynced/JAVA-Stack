<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h1 class="color-change">Welcome, <c:out value="${loggedInUser.userName}"/>!</h1>
	<p>This is your dashboard. Nothing to see here yet.</p>
	<a href="/users/login/register">Logout</a>
</body>
</html>