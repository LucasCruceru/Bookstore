<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Order</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/order/addOrder" method="post" commandName="orderForm">
       
<table>
<tr>
	<td>Date Ordered</td>
	<td><form:input path="dateOrder" /></td>
</tr>
<tr>
	<td>Total Price</td>
	<td><form:input path="totalPrice" /></td>
</tr>
<tr>
	<td>CustomerID</td>
	<td><form:input path="customerID" /></td>
</tr>

<tr>
<td><a href="<c:url value="/order.htm"/>">Back to list</a></td>
<td><input type=submit value="Save"/></td>
</tr>
</table>
</form:form>
</body>
</html>