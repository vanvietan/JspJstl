<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>	
	<h1>Welcome to JSP Demo Project.</h1>
	<h2>Nguyễn Văn Viết An - 1995</h2>
	<%for(int i = 1; i<=10; i++) {%>
		<h3>Count --> <%= i %></h3>
	<% }%>

</body>
</html>