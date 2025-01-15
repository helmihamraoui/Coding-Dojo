<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-5">
<h1 class="title">All Books</h1>
<table class="mt-2 table table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="book" items="${books}">
                <tr>
                	<td>${book.id}</td>
                    <td> <a href="/books/${book.id}">${book.title}</a></td>
         			<td>${book.language}</td>
         			<td>${book.numberOfPages}</td>
                </tr>
            </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>