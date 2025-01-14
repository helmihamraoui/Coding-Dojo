<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container p-5">
	<div class="d-flex justify-content-between align-items-center p-5">
		<h1 class="">Your Gold: <span class="border border-3 ms-3 p-1">${gold}</span></h1>
		<form action="/form" method="POST">
			<input type="hidden" name="name" value="reset">
			<button class="btn btn-danger">Reset</button>
		</form>
	</div>
	<div class="row m-5">
		<form action="/form" method="POST" class="col rounded border-dark p-4 m-1 text-center card">
			<h2>Farm</h2>
			<input type="hidden" name="name" value="farm">
			<p>(earns 10-20 gold)</p>
			<button class="btn btn-dark">Find Gold!</button>
		</form>
		<form action="/form" method="POST" class="col border-dark p-4 m-1 text-center card">
			<h2>Cave</h2>
			<input type="hidden" name="name" value="cave">
			<p>(earns 5-10 gold)</p>
			<button class="btn btn-dark">Find Gold!</button>
		</form>
		<form action="/form" method="POST" class="col border-dark p-4 m-1 text-center card">
			<h2>House</h2>
			<input type="hidden" name="name" value="house">
			<p>(earns 2-5 gold)</p>
			<button class="btn btn-dark">Find Gold!</button>
		</form>
		<form action="/form" method="POST" class="col border-dark p-4 m-1 text-center card">
			<h2>Quest</h2>
			<input type="hidden" name="name" value="quest">
			<p>(earns/takes 0-50 gold)</p>
			<button class="btn btn-dark">Find Gold!</button>
		</form>
		<form action="/form" method="POST" class="col border-dark p-4 m-1 text-center card">
			<h2>Spa</h2>
			<input type="hidden" name="name" value="spa">
			<p>(lose 5-20 gold)</p>
			<button class="btn btn-dark">Go to Spa</button>
		</form>
	</div>
	<div class="m-5">
		<h3 class="m-3">Activities:</h3>
		<div class="border border-dark p-3">
			<c:forEach var="msg" items="${earns}">
				<p class="text-success">${msg}</p>
			</c:forEach>
			<c:forEach var="msg" items="${lose}">
				<p class="text-danger"><c:out value="${msg}" /></p>
			</c:forEach>
			
		</div>
	</div>
</div>
</body>
</html>
