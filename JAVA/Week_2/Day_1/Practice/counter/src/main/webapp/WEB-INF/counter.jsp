<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>you have visited http://localhost:8080 <c:out value="${count}"/> times</h3>
<a href="/">Test another visit ?</a>
<a href="/reset">reset</a>
</body>
</html>