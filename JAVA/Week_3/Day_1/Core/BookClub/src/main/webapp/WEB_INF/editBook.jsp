  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <title>Edit Book</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/books">Book Club</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </nav>

    <div class="container my-5">
        <div class="card">
            <div class="card-header bg-warning text-dark">
                <h3>Edit Book Details</h3>
            </div>
            <div class="card-body">
                <!-- Spring Form -->
			<div class="container mt-4">
			<form:form modelAttribute="book" method="POST" action="/books/${book.id}/edit">
	<input type="hidden" name="_method" value="PUT">
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
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
</body>
</html>
