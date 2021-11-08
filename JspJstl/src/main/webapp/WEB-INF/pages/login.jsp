<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body>
	<div class="container-fluid">
		<h1>Login</h1>
		<form action="" method="post">
        <div class="form-group">
          <label for="username">Username</label>
          <input type="text" class="form-control" name="username" id="username" aria-describedby="helpId" placeholder="Enter username">
          <small id="helpId" class="form-text text-muted">username can not be blank</small>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" class="form-control" name="password" id="password" aria-describedby="passwordHelp" placeholder="Enter password">
          <small id="passwordHelp" class="form-text text-muted">password is not correct</small>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
      </form>
	</div>
</body>
</html>