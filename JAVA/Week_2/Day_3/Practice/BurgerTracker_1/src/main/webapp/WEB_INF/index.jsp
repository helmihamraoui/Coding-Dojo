<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <title>Create To-Do</title>
</head>
<body>
<div class="container">
<div>
<h1>Burger Tracker</h1>
<table class="table table-striped">
<thead>
<tr>
<th>Burger Name</th>
<th>Restaurant Name</th>
<th>Rating(out of 5)</th>
</tr>
</thead>
<tbody>
${burgers}
<c:forEach var="burger" items="${burgers}">
<tr>
<td>
<c:out value="${burger.name }"></c:out>
</td>
<td>
<c:out value="${burger.resto }"></c:out>
</td>
<td>
<c:out value="${burger.rate }"></c:out>
</td>
</tr>
</c:forEach>
</tbody>
</table>




</div>








<form:form modelAttribute="burger" method="POST" action="/" class="mt-4">
<h1>AddABurger :</h1>
<div>
	<form:label path="name">Burger Name:</form:label>
	<form:input path="name" class="form-control"/>
	<form:errors class="badge text-danger" path="name"/>
</div>
<div>
	<form:label path="resto">Restaurant Name:</form:label>
	<form:input path="resto" class="form-control"/>
	<form:errors class="badge text-danger" path="resto"/>
</div>
<div>
	<form:label path="rate">Rating:</form:label>
	<form:input path="rate" class="form-control"/>
	<form:errors class="badge text-danger" path="rate"/>
</div>
<div>
	<form:label path="note">Notes:</form:label>
	<form:textarea path="note" class="form-control"/>
	<form:errors class="badge text-danger" path="note"/>
</div>
<button type="submit" class="btn btn-primary mt-4">Save</button>
</form:form>
    </div>
</body>
</html>