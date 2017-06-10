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
 		<th>Date Ordered</th>
 		<th>Total Price</th>
   		<th>CustomerID</th>
   		<th></th>
   		<th></th>
   		<th></th>
  	</tr>
  	<c:forEach var="o" items="${model['orderList']}">
		<tr>
			<td><c:out value="${o.ID}"/></td>
	   		<td><c:out value="${o.dateOrder}"/></td>
	   		<td><c:out value="${o.totalPrice}"/></td>
	   		<td><c:out value="${o.customerID}"/></td>

	   		<td><a href="<c:url value="/order/details/${o.ID}"/>">Details</a></td>
	   		<td><a href="<c:url value="/order/edit/${o.ID}"/>">Edit</a></td>
	   		<td><a href="<c:url value="/order/delete/${o.ID}"/>">Delete</a></td>	   		
		</tr>
	</c:forEach>
</table>

<a href="<c:url value="/order/add"/>">Add Order</a>

</body>
</html>