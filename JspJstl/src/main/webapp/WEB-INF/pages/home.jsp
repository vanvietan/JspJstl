<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page </title>
</head>
<body>
	<h1>Home Page is here</h1>
	<h2><%= session.getAttribute("fullname") %></h2>
</body>
</html>