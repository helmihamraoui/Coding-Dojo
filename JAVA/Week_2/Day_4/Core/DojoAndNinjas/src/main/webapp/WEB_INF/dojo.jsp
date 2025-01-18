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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-4">
	<h1 class="text-primary"> <c:out value="${dojo.name}"></c:out> Ninjas</h1>
	    <table class="table table-striped mt-3">
	    
	        <thead>
	            <tr>
	                <th>First Name</th>
	                <th>Last Name</th>
	                <th>Age</th>
	            </tr>
	        </thead>
	        <tbody>
	<c:forEach var="ninja" items="${dojo.getNinjas()}">
	<tr>
	<td>${ninja.first_name}</td>
	<td>${ninja.last_name}</td>
	<td>${ninja.age}</td>
	</tr>
	</c:forEach>
	    </tbody>
	</table>
	</div>
</body>
</html>