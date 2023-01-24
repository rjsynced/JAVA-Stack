<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
	<div>
		<h1>Here's Your Omikuji!</h1>
		<p>
			In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${name}"/> as your roommate,
			<c:out value="${hobby}"/> for a living. The next time you see a <c:out value="${thing}"/>, you will have good luck.
			Also, <c:out value="${message}"/>.
		</p>
		<a href="/">Go Back</a>
	</div>
</body>
</html>