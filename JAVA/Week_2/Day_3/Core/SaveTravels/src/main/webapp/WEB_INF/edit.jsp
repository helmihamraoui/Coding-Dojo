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
    <title>Travel</title>
</head>
<body>
<div class="container mt-4">
<div class="d-flex justify-content-between align-items-center"><h1 class="text-success">Edit Expense</h1>
<a href="/expense" >Go Back</a></div>
<form:form modelAttribute="travel" method="POST" action="/expense/edit/${id}">
	<input type="hidden" name="_method" value="PUT">
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