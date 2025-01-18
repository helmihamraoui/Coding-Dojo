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
<title></title>
</head>
<body>
<div class="container mt-4">
	<h1 class="text-primary"> New Ninja :</h1>
	<form:form modelAttribute="ninja" method="POST" action="/ninjas/new">
	<div> &
     <form:label path="dojo">Dojos: </form:label>
     <form:select path="dojo.id" class="form-control"> 
     <form:options items="${dojos}" itemValue="id" itemLabel="name"/> 
     </form:select> 
     <form:errors path="dojo"/> 
     </div>
	<div>
	<form:label path="first_name">First Name:</form:label>
	<form:input path="first_name" class="form-control"/>
	<form:errors class="badge text-danger" path="first_name"/>
	</div>
	<div>
	<form:label path="last_name">Last Name:</form:label>
	<form:input path="last_name" class="form-control"/>
	<form:errors class="badge text-danger" path="last_name"/>
	</div>
	<div>
	<form:label path="age">Age:</form:label>
	<form:input type="number" path="age" class="form-control"/>
	<form:errors class="badge text-danger" path="age"/>
	</div>
	<button type="submit" class="btn btn-primary mt-2">Save</button>
	</form:form>
</body>
</html>