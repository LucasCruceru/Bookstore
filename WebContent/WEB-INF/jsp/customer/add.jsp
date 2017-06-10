<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/customer/addCustomer" method="post" commandName="customerForm">
       
<table>
<tr>
	<td>First Name</td>
	<td><form:input path="firstName" /></td>
</tr>
<tr>
	<td>Last Name</td>
	<td><form:input path="lastName" /></td>
</tr>
<tr>
	<td>Email</td>
	<td><form:input path="email" /></td>
</tr>
<tr>
	<td>Address</td>
	<td><form:input path="address" /></td>
</tr>

<tr>
	<td>City</td>
	<td><form:input path="city" /></td>
</tr>
<tr>
	<td>District</td>
	<td><form:input path="district" /></td>
</tr>
<tr>
	<td>Country</td>
	<td><form:input path="country" /></td>
</tr>
<tr>
<td><a href="<c:url value="/customer.htm"/>">Back to list</a></td>
<td><input type=submit value="Save"/></td>
</tr>
</table>
</form:form>
</body>
</html>