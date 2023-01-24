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
			<div class="d-flex justify-content-between">
				<div>
					<c:if test="${loggedInUser.id == 1}">
						<a class="btn btn-outline-primary btn-small px-2" href="/classes/create">+ Add New Class</a>
						<a class="btn btn-outline-primary btn-small px-2" href="/races/create">+ Add New Race</a>
					</c:if>
					<a class="btn btn-warning btn-small px-2" href="/campaigns/create">+ Create Campaign</a>
					<a class="btn btn-success btn-small" href="/characters/create">+ Add New Character</a>
					<a class="btn btn-dark btn-small" href="/users/logout">Logout</a>
				</div>
			</div>
		</div>
		<div class="container">
			<h1>Current Active Campaigns:</h1>
			<table class="table table-striped table-dark">
			  <thead>
			    <tr>
			      	<th scope="col">Campaign</th>
			      	<th scope="col">Dungeon Master</th>
			      	<th scope="col">#'s of Players</th>
			      	<th scope="col">Description</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="campaign" items="${allCampaigns}" >
			  		<c:if test="${campaign.isPublic == true}">
					    <tr>
					    	<td><c:out value="${campaign.name}"/></td>
					      	<td><c:out value="${campaign.user.userName}"/></td>
					      	<td><c:out value="${campaign.numOfPlayers}"/></td>
					      	<td><c:out value="${campaign.description}"/></td>
					    </tr>
					</c:if>
					<c:if test="${campaign.isPublic == false && loggedInUser.id == campaign.user.id}">
						<tr>
					    	<td><c:out value="${campaign.name}"/></td>
					      	<td><c:out value="${campaign.user.userName}"/></td>
					      	<td><c:out value="${campaign.numOfPlayers}"/></td>
					      	<td><c:out value="${campaign.description}"/></td>
					    </tr>
					</c:if>
					
				</c:forEach>
			   </tbody>
			</table>		
		</div>
		<div class="container">
			<h1>All Characters</h1>
			<table class="table table-striped table-dark">
			  <thead>
			    <tr>
			      	<th scope="col">Name</th>
			      	<th scope="col">Level</th>
			      	<th scope="col">Actions</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="character" items="${allCharacters}" >
				    <tr>
				    	<td><a href="/characters/view/${character.id}"><c:out value="${character.name}"/></a></td>
				      	<td><c:out value="${character.level}"/></td>
				    	<td class="d-flex px-4">
				    		<c:if test="${loggedInUser == character.user}">
								<a class="btn btn-info btn-small" href="/characters/edit/${character.id}">Edit</a>
								<form action="/characters/delete/${character.id}" method="post">
									<input type="hidden" value="Delete" name="_method" />
									<input class="btn btn-danger btn-small" type="submit" value="Delete" />
								</form>	
							</c:if>
				    	</td>
				    </tr>
				</c:forEach>
			 </tbody>
			</table>		
		</div>
	</div>
</body>
</html>