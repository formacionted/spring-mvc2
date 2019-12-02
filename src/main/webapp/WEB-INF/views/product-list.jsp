<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List | Awesome App</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	
	<div class = "pt-5 container">
		
		<h1>Products Directory</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<a class = "btn btn-primary" href="${pageContext.request.contextPath}/products/empty">Add Product</a>
			
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${products}" var="product">
			
				<tr>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.quantity}</td>
					<td> 
						<a class="btn btn-info" href = "${pageContext.request.contextPath}/products/${product.id}">Edit</a> 
						<a class="btn btn-danger" href = "${pageContext.request.contextPath}/products/${product.id}/delete">Delete</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>