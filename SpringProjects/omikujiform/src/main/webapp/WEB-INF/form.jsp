<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Send an Omikuji!!!</h1>
		<form action="/omikuji/process" method="post">
			<div>
				<label>Pick any number from 5 to 25</label>
				<input type="number" min=5 max=25 name="number" />
			</div>
			<div>
				<label>Enter the name of any city.</label>
				<input type="text" name="city" />
			</div>
			<div>
				<label>Enter the name of any real person</label>
				<input type="text" name="name" />
			</div>
			<div>
				<label>Enter professional endeavor or hobby:</label>
				<input type="text" name="hobby" />
			</div>
			<div>
				<label>Enter any type of living thing.</label>
				<input type="text" name="thing" />
			</div>
			<div>
				<label>Say something nice to someone:</label>
				<textarea name="message"></textarea>
			</div>
			<p>Send and show a friend</p>
			<input type="submit" />
		</form>
	</div>
</body>
</html>