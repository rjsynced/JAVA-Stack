<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Login Page</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<section class="vh-100 gradient-custom2">
	  <div class="container py-5 h-100">
	    <div class="row d-flex justify-content-center align-items-center h-100">
	      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
	        <div class="card bg-dark text-white" style="border-radius: 1rem;">
	          <div class="card-body p-5 text-center">
	            <div class="mb-md-5 mt-md-4 pb-5">
	            	<form:form action="/users/login" method="POST" modelAttribute="loginUser">
	                  <div class="d-flex align-items-center mb-3 pb-1">
	                    	<h1 class="fw-bold mb-2 text-uppercase">DnD Campaign Builder</h1>
	                  </div>
	                  <h5 class="text-white-50 mb-5" style="letter-spacing: 1px;">Sign into your account</h5>
	                  <div class="form-outline form-white mb-4">
	                    <label class="form-label">Email address</label>
	                    <form:input type="email" path="email" class="form-control form-control-lg" />
	                    <form:errors type="email" path="email" class="text-danger" />
	                  </div>
	                  <div class="form-outline form-white mb-4">
	                    <label class="form-label">Password</label>
	                    <form:input type="password" path="password" class="form-control form-control-lg" />
	                    <form:errors type="password" path="password" class="text-danger" />
	                  </div>
	                  <div class="pt-1 mb-4">
	                    <input type="submit" class="btn btn-outline-light btn-lg px-5" value="Login" />
	                  </div>
	                  <p class="text-white-50 fw-bold" style="color: #393f81;">Don't have an account? <a href="/users/register"
	                      style="color: #393f81;">Register here</a></p>
	                  <a href="#!" class="small text-muted">Terms of use.</a>
	                  <a href="#!" class="small text-muted">Privacy policy</a>
					</form:form>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>
</body>
</html>