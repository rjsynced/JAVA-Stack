<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Character</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div>
			<div class="d-flex align-items-center justify-content-between">
				<h1>Create Your Character</h1>
				<a class="btn btn-info btn-small" href="/campaigns">Back to home</a>
			</div>
		</div>
		<div class="card-body">
			<form:form action="/characters/create" method="POST" modelAttribute="character" enctype="multipart/form-data">
				<form:input type="hidden" value="${user_id}" path="user" />
				<div class="form-outline mb-4">
					<label>Name</label>
					<form:input path="name" class="form-control" style="width: 15rem"/>
					<form:errors path="name" class="text-danger"/>
				</div>
     			<div class="d-flex">
					<div class="form-outline mb-4">
						<label>STR</label>
						<form:input path="strength" class="form-control" size="1"/>
						<form:errors path="strength" class="text-danger"/>
					</div>
					<div class="form-outline mb-4">
						<label>DEX</label>
						<form:input path="dexterity" class="form-control" size="1"/>
						<form:errors path="dexterity" class="text-danger"/>
					</div>
					<div class="form-outline mb-4">
						<label>CON</label>
						<form:input path="constitution" class="form-control" size="1"/>
						<form:errors path="constitution" class="text-danger"/>
					</div>
					<div class="form-outline mb-4">
						<label>INT</label>
						<form:input path="intelligence" class="form-control" size="1"/>
						<form:errors path="intelligence" class="text-danger"/>
					</div>
					<div class="form-outline mb-4">
						<label>WIS</label>
						<form:input path="wisdom" class="form-control" size="1"/>
						<form:errors path="wisdom" class="text-danger"/>
					</div>
					<div class="form-outline mb-4">
						<label>CHA</label>
						<form:input path="charisma" class="form-control" size="1"/>
						<form:errors path="charisma" class="text-danger"/>
					</div>
					<div class="form-outline mb-4">
						<label>Level</label>
						<form:input path="level" class="form-control" size="1"/>
						<form:errors path="level" class="text-danger"/>
					</div>
     			</div>
				<div class="mb-4">
					<button type="button" id="button">Roll Random Stat </button><label id="placeholder"></label>
				</div>
				<div class="d-flex">
					<div class="form-outline mb-4">
						<form:label path="race" >Race: </form:label>
						<form:select path="race">
							<c:forEach var="race" items="${races}">
								<form:option value="${race.id}"> ${race.name} </form:option>
							</c:forEach>
						</form:select>
					</div>
					<div id="result"></div>
					<div class="form-outline mb-4">
						<form:label path="pClass" >Class: </form:label>
						<form:select path="pClass">
							<c:forEach var="job" items="${jobs}">
								<form:option value="${job.id}"> ${job.name} </form:option>
							</c:forEach>
						</form:select>
					</div>
				
				</div>
				<div class="form-outline mb-4 d-flex">
					<label>Description</label>
					<textarea name="description" cols="25" rows="3"></textarea>
					<form:errors path="description" class="text-danger"/>
				</div>
				<div>
					<input type="submit" value="Submit" class="btn btn-primary btn-small" />
				</div>
			</form:form>
		</div>
	</div>
	<script type="text/javascript" src="/js/ascalc.js"></script>
</body>
</html>
