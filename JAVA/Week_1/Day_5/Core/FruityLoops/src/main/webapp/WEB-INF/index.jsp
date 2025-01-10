<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Fruity Loops</title>
</head>
<body>
<div class="container">
<h1 class="Title mt-5">Fruit Store</h1>
<table class="table table-bordered mt-5">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
  <tbody>
        <c:forEach var="fruit" items="${fruits}">
    <tr>
      <td>${fruit.name}</td>
      <td>$${fruit.price}</td>
    </tr>
        </c:forEach>
   </tbody>
   <ul>
        
    </ul>
</div>
</table>
</body>
</html>