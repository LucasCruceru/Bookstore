<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>
<table>
<tr>
	<td>ID</td>
	<td><c:out value="${model.product.ID}"/></td>
</tr>
<tr>
	<td>Name</td>
	<td><c:out value="${model.product.name}"/></td>
</tr>
<tr>
	<td>Price</td>
	<td><c:out value="${model.product.price}"/></td>
</tr>
<tr>
	<td>Number of products available</td>
	<td><c:out value="${model.product.nrInStore}"/></td>
</tr>
<tr>
	<td>Description</td>
	<td><c:out value="${model.product.description}"/></td>
</tr>

</table>
<a href="<c:url value="/product.htm"/>">Back to list</a>
</body>
</html>