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
    <title>Books</title>
</head>
<body>
	<div class="container mt-4">
<h1>Add a New Book</h1>	
	<form:form modelAttribute="book" method="POST" action="/book/new">
	<div>
	<form:label path="title">Title:</form:label>
	<form:input path="title" class="form-control"/>
	<form:errors class="badge text-danger" path="title"></form:errors>
	</div>
	<div>
	<form:label path="author">Author:</form:label>
	<form:input path="author" class="form-control"/>
	<form:errors class="badge text-danger" path="author"></form:errors>
	</div>
	<div>
	<form:label path="thoughts">My thoughts:</form:label>
	<form:input  path="thoughts" class="form-control"/>
	<form:errors class="badge text-danger" path="thoughts"></form:errors>
	</div>
	<button type="submit" class="btn btn-primary mt-2">Save</button>
	</form:form>
</div>
</body>
</html>