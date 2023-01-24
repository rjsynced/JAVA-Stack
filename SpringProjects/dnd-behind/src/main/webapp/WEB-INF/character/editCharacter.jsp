<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Course</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div>
			<div class="d-flex align-items-center justify-content-between">
				<h1>Edit Your Character</h1>
				<a href="/campaigns">Back to home</a>
			</div>
		</div>
			<form:form action="/characters/edit/${character.id}" method="PUT" modelAttribute="character">
				<form:input type="hidden" path="user" />
				<div class="form-group">
					<label>Name</label>
					<form:input path="name" class="form-control" style="width: 15rem"/>
					<form:errors path="name" class="text-danger"/>
				</div>
     			<div class="d-flex">
					<div class="form-group">
						<label>STR</label>
						<form:input path="strength" class="form-control" size="1"/>
						<form:errors path="strength" class="text-danger"/>
					</div>
					<div class="form-group">
						<label>DEX</label>
						<form:input path="dexterity" class="form-control" size="1"/>
						<form:errors path="dexterity" class="text-danger"/>
					</div>
					<div class="form-group">
						<label>CON</label>
						<form:input path="constitution" class="form-control" size="1"/>
						<form:errors path="constitution" class="text-danger"/>
					</div>
					<div class="form-group">
						<label>INT</label>
						<form:input path="intelligence" class="form-control" size="1"/>
						<form:errors path="intelligence" class="text-danger"/>
					</div>
					<div class="form-group">
						<label>WIS</label>
						<form:input path="wisdom" class="form-control" size="1"/>
						<form:errors path="wisdom" class="text-danger"/>
					</div>
					<div class="form-group">
						<label>CHA</label>
						<form:input path="charisma" class="form-control" size="1"/>
						<form:errors path="charisma" class="text-danger"/>
					</div>
					<div class="form-group">
						<label>Level</label>
						<form:input path="level" class="form-control" size="1"/>
						<form:errors path="level" class="text-danger"/>
					</div>
     			</div>
				<div class="form-group">
					<form:label path="race" >Race: </form:label>
					<form:select path="race">
						<c:forEach var="race" items="${races}">
							<form:option value="${race.id}"> ${race.name} </form:option>
						</c:forEach>
					</form:select>
				</div>
				<div id="result"></div>
				<div class="form-group">
					<form:label path="pClass" >Class: </form:label>
					<form:select path="pClass">
						<c:forEach var="job" items="${jobs}">
							<form:option value="${job.id}"> ${job.name} </form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group d-flex">
					<label>Description</label>
					<form:input path="description" class="form-control" size="2"/>
						<form:errors path="description" class="text-danger"/>
				</div>
				<div>
					<input type="submit" value="Submit" class="btn btn-primary mt-4" />
				</div>
			</form:form>
				<div class="d-flex align-items-end">
					<c:if test="${loggedInUser == character.user}">
						<form action="/characters/delete/${character.id}" method="post">
								<input type="hidden" value="Delete" name="_method" />
								<input class="btn btn-danger" type="submit" value="Delete" />
						</form>	
					</c:if>
				</div>
	</div>
</body>
</html>