<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container p-4 card mt-5">
    <div class="d-flex justify-content-between align-items-center">
        <h1 class="text-primary">Expenses Details</h1>
        <a href="/expense" class="btn btn-primary">Go Back</a>
    </div>
        <div><strong>Expenses Name :</strong> ${travel.name}</div>
        <div><strong>Expenses Description :</strong> ${travel.description}</div>
        <div><strong>Vendor : </strong>${travel.vendor}</div>
        <div><strong>Amount :</strong> ${travel.amount}</div>
    </div>
</body>
</html>