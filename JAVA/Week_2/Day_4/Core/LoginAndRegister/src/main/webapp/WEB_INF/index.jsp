<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    .box1{
        background-color: #34393E;
        color: aliceblue;
    }
</style>
<body>
<div class="container d-flex justify-content-between">
<div class="box1 col-5 card shadow p-3 border  mt-5">
<h1 class="text-center text-primary" >REGISTER</h1>
<form:form action="/register" method="POST" modelAttribute="newUser">
<div class="form-group mb-3">
<form:label path="userName" class="form-label"> User Name :</form:label>
<form:input path="userName" class="form-control" />
<form:errors path="userName" class="text-danger" ></form:errors>
</div>
<div class="form-group mb-3">
<form:label path="email" class="form-label">Email :</form:label>
<form:input path="email" class="form-control" />
<form:errors path="email" class="text-danger"></form:errors>
</div>
<div class="form-group mb-3">
<form:label path="password" class="form-label">Passowrd :</form:label>
<form:input path="password" class="form-control" />
<form:errors path="password" class="text-danger"></form:errors>
</div>
<div class="form-group mb-3">

<form:label path="confirm" class="form-label">Confirm passowrd :</form:label>
<form:input path="confirm" class="form-control" />
<form:errors path="confirm" class="text-danger"></form:errors>
</div>
<button class="btn btn-primary">Register</button>
</form:form>
</div>
<div class="box1 col-5 card shadow p-3 border mt-5">
            <h1 class="text-center text-success">LOGIN</h1>
<form:form action="/login" method="POST" modelAttribute="newLogin">
<div class="form-group mb-3">
<form:label path="email" class="form-label" >Email :</form:label>
<form:input path="email" class="form-control" />
<form:errors path="email" class="text-danger"></form:errors>
</div>
<div class="form-group mb-3">
<form:label path="password">passowrd :</form:label>
<form:input path="password" class="form-control"/>
<form:errors path="password" class="text-danger"></form:errors>
</div>
<button>Login</button>
</form:form>
</div>
</div>
</body>
</html>