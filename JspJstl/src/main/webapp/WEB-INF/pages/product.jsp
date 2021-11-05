<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cybersoft.javabackend.java14.jsp.jstl.util.UrlConst" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Product Page</title>
	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body>
		<div class="container-fluid">
      <h1>Product page</h1>
         <form action ="<%= request.getContextPath()+ UrlConst.PRODUCT_ADD %>" method ="get">
      	<label>ID: </label>
      	<input type="text" name="id">
      	<br>
      	<label>Name: </label>
      	<input type="text" name="name">
      	<br>
      	<label>Description: </label>
      	<input type="text" name="description">
      	<br>
      	<label>Price: </label>
      	<input type ="text" name="price">
      	<br>
      	<label>Stock: </label>
      	<input type="text" name="stock">
      	<br>
      	<button type="submit">Add</button>
      </form>
        
    
        <!-- ---------------------------- -->
      <table class="table mt-5">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Description</th>
              <th>Price</th>
              <th>Stock</th>
              <th>#</th>
            </tr>
          </thead>
          <tbody>
          	<c:forEach var="product" items="${products}">
          		<tr>
	              <td>${product.id}</td>
	              <td>${product.name}</td>
	              <td>${product.description}</td>
	              <td>$${product.price}</td>
	              <td>${product.stock}</td>
	              <td><a class="btn btn-sm btn-danger" href="<%= request.getContextPath() + UrlConst.PRODUCT_REMOVE%>?id=${product.id}">Remove</a></td>
	            </tr>
          	</c:forEach>
          </tbody>
        </table>
    </div>
	</body>
</html>