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
	<td><c:out value="${model.orderDetails.ID}"/></td>
</tr>
<tr>
	<td>Order ID</td>
	<td><c:out value="${model.orderDetails.orderID}"/></td>
</tr>
<tr>
	<td>Product ID</td>
	<td><c:out value="${model.orderDetails.productID}"/></td>
</tr>
</table>
<a href="<c:url value="/orderDetails.htm"/>">Back to list</a>
</body>
</html>