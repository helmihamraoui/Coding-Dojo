<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1>Here's Your Omikuji!</h1>
<div class="card card-body p-2 col-5 h-75 w-300 ">
<h2>In <c:out value="${number}"></c:out> years, you will live in <c:out value="${nameOfCity}"></c:out> with <c:out value="${personName}"></c:out> 
 as your roomate, selling <c:out value="${hobby}"></c:out>
  for living. The next time you see <c:out value="${type}"></c:out>,
  you will have good luck. Also,<c:out value="${something}"></c:out></h2>
</div>
<a href="/omikuji">Go Back</a>

</body>
</html>