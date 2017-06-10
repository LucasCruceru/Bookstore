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
 		<th>First Name</th>
 		<th>Last Name</th>
   		<th>Email</th>
   		<th>Address</th>
   		<th>City</th>
   		<th>District</th>
   		<th>Country</th>
   		<th></th>
   		<th></th>
   		<th></th>
  	</tr>
  	<c:forEach var="c" items="${model['customerList']}">
		<tr>
			<td><c:out value="${c.ID}"/></td>
	   		<td><c:out value="${c.firstName}"/></td>
	   		<td><c:out value="${c.lastName}"/></td>
	   		<td><c:out value="${c.email}"/></td>
	   		<td><c:out value="${c.address}"/></td>
	   		<td><c:out value="${c.city}"/></td>
	   		<td><c:out value="${c.district}"/></td>
	   		<td><c:out value="${c.country}"/></td>
	   		
	   		<td><a href="<c:url value="/customer/details/${c.ID}"/>">Details</a></td>
	   		<td><a href="<c:url value="/customer/edit/${c.ID}"/>">Edit</a></td>
	   		<td><a href="<c:url value="/customer/delete/${c.ID}"/>">Delete</a></td>	   		
		</tr>
	</c:forEach>
</table>

<a href="<c:url value="/customer/add"/>">Add Customer</a>

</body>
</html>