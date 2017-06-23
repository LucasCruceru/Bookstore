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
 		<th>OrderID</th>
 		<th>ProductID</th>

   		<th></th>
   		<th></th>
   		<th></th>
  	</tr>
  	<c:forEach var="od" items="${model['orderDetailsList']}">
		<tr>
			<td><c:out value="${od.ID}"/></td>
	   		<td><c:out value="${od.orderID}"/></td>
	   		<td><c:out value="${od.productID}"/></td>

	   		<td><a href="<c:url value="/orderDetails/details/${od.ID}"/>">Details</a></td>
	   		<td><a href="<c:url value="/orderDetails/edit/${od.ID}"/>">Edit</a></td>
	   		<td><a href="<c:url value="/orderDetails/delete/${od.ID}"/>">Delete</a></td>	   		
		</tr>
	</c:forEach>
</table>

<a href="<c:url value="/orderDetails/add"/>">Add OrderDetails</a>

</body>
</html>