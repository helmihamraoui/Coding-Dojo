<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Details</title>
</head>
<body>
    <h1>Book Details</h1>
    <p><strong>Title:</strong> ${book.title}</p>
    <p><strong>Description:</strong> ${book.description}</p>
    <p><strong>language:</strong> ${book.language}</p>
    <p><strong>Number of Pages:</strong> ${book.numberOfPages}</p>
</body>
</html>