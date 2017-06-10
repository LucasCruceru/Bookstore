<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
</head>
<body>
<table border=1>
	<tr>
 		<th>Id</th>
 		<th>Name</th>
 		<th>Price</th>
   		<th>Number products available</th>
   		<th>Description</th>
   		<th></th>
   		<th></th>
   		<th></th>
  	</tr>
  	<c:forEach var="p" items="${model['productList']}">
		<tr>
			<td><c:out value="${p.ID}"/></td>
	   		<td><c:out value="${p.name}"/></td>
	   		<td><c:out value="${p.price}"/></td>
	   		<td><c:out value="${p.nrInStore}"/></td>
	   		<td><c:out value="${p.description}"/></td>

	   		<td><a href="<c:url value="/product/details/${p.ID}"/>">Details</a></td>
	   		<td><a href="<c:url value="/product/edit/${p.ID}"/>">Edit</a></td>
	   		<td><a href="<c:url value="/product/delete/${p.ID}"/>">Delete</a></td>	   		
		</tr>
	</c:forEach>
</table>

<a href="<c:url value="/product/add"/>">Add Product</a>

</body>
</html>