<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container d-flex flex-column justify-content-center mt-5 " >
<h1 class="mb-4 ml-3">Send an Omikuji!</h1>
<form action="/omikuji/show" method="Post" class="d-flex flex-column col-4 p-3 card card-body" >
<label>Pick any number from 5 to 25</label>
<input type="number" class="form-control" name="number">
<label>Enter the name of the city</label>
<input class="form-control" name="nameOfCity">
<label>Enter the name of any real person</label>
<input class="form-control" name="personName">
<label>Enter professional endeavor or hobby:</label>
<input class="form-control" name="hobby">
<label>Enter any type of living thing</label>
<input class="form-control" name="type">
<label>Say something nice to someone:</label>
<textarea class="form-control" name="something" rows="4"></textarea>
<h3>Send and show a friend</h3>
<button class="col-3 btn btn-success">Send</button>
</form>
</div>
</body>
</html>