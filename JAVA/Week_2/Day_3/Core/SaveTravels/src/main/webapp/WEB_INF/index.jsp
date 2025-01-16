<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Travel</title>
</head>
<body>
	<div class="container mt-4">
	<h1 class="text-primary">Save Travels</h1>
	    <table class="table table-striped mt-3">
	        <thead>
	            <tr>
	                <th>Expense Name</th>
	                <th>Vendor</th>
	                <th>Amount</th>
	                <th>Actions</th>
	            </tr>
	        </thead>
	        <tbody>
	<c:forEach var="travel" items="${Travels}">
	<tr>
	<td><a href="/expense/${travel.id}">${travel.name}</a></td>
	<td>${travel.vendor}</td>
	<td>${travel.amount}</td>
	<td>
	    <a href="/expense/edit/${travel.id}" class="btn btn-primary btn-sm me-2">Edit</a>
	    <form action="/expense/delete/${travel.id}" method="POST" style="display: inline;">
	        <input type="hidden" name="_method" value="DELETE">
	        <button class="btn btn-danger btn-sm">Delete</button>
	    </form>
	    </td>
	</tr>
	</c:forEach>
	    </tbody>
	</table>
	
	<form:form modelAttribute="travel" method="POST" action="/expense">
	<div>
	<form:label path="name">Expense Name:</form:label>
	<form:input path="name" class="form-control"/>
	<form:errors class="badge text-danger" path="name"/>
	</div>
	<div>
	<form:label path="vendor">Vendor:</form:label>
	<form:input path="vendor" class="form-control"/>
	<form:errors class="badge text-danger" path="vendor"/>
	</div>
	<div>
	<form:label path="amount">Amount:</form:label>
	<form:input  path="amount" class="form-control"/>
	<form:errors class="badge text-danger" path="amount"/>
	</div>
	<div>
	<form:label path="description">Description:</form:label>
	<form:textarea path="description" class="form-control"></form:textarea>
	<form:errors class="badge text-danger" path="description"/>
	</div>
	<button type="submit" class="btn btn-primary mt-2">Save</button>
	</form:form>
</div>
</body>
</html>