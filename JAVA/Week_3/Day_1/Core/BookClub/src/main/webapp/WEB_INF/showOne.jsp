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
    <title>Book Details</title>
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
            <div class="card-header bg-primary text-white">
                <h3>${book.title}</h3>
            </div>
            <div class="card-body">
                <h5 class="card-title">Author: <span class="text-muted">${book.author}</span></h5>
                <p class="card-text"><strong>Posted By:</strong> ${book.user.userName}</p>
                <p class="card-text"><strong>Thoughts:</strong></p>
                <blockquote class="blockquote">
                    <p class="mb-0">${book.thoughts}</p>
                </blockquote>
            </div>
            <div class="card-footer text-muted d-flex justify-content-between">
                <a href="/books" class="btn btn-secondary btn-sm">Back to List</a>
               <c:if test="${userId == book.user.id}">
                <div>
                    <a href="/books/${book.id}/edit" class="btn btn-warning btn-sm">Edit</a>
                    <form action="/books/${book.id}/delete" method="POST" class="d-inline">
                    <input type="hidden" name="_method" value="DELETE">
                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                    </form>
                </div>
               </c:if>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
</body>
</html>
