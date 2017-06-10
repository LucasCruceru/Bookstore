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
	<td><c:out value="${model.order.ID}"/></td>
</tr>
<tr>
	<td>Date Ordered</td>
	<td><c:out value="${model.order.dateOrder}"/></td>
</tr>
<tr>
	<td>Total Price</td>
	<td><c:out value="${model.order.totalPrice}"/></td>
</tr>
<tr>
	<td>Customer ID</td>
	<td><c:out value="${model.order.customerID}"/></td>
</tr>

</table>
<a href="<c:url value="/order.htm"/>">Back to list</a>
</body>
</html>