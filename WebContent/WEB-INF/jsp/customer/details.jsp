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
	<td><c:out value="${model.customer.ID}"/></td>
</tr>
<tr>
	<td>First Name</td>
	<td><c:out value="${model.customer.firstName}"/></td>
</tr>
<tr>
	<td>Last Name</td>
	<td><c:out value="${model.customer.lastName}"/></td>
</tr>
<tr>
	<td>Email</td>
	<td><c:out value="${model.customer.email}"/></td>
</tr>
<tr>
	<td>Address</td>
	<td><c:out value="${model.customer.address}"/></td>
</tr>
<tr>
	<td>City</td>
	<td><c:out value="${model.customer.city}"/></td>
</tr>
<tr>
	<td>District</td>
	<td><c:out value="${model.customer.district}"/></td>
</tr>
<tr>
	<td>Country</td>
	<td><c:out value="${model.customer.country}"/></td>
</tr>

</table>
<a href="<c:url value="/customer.htm"/>">Back to list</a>
</body>
</html>