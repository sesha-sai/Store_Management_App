<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CartItem Page</title>
</head>
<body>
 <spring:url value="/cartItem/add" var="addURL" />
 <a href="${addURL }">Add CartItem</a>

 <h1>CartItem List</h1>
 <style>
table {
  width:100%;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
table#t01 tr:nth-child(even) {
  background-color: #eee;
}
table#t01 tr:nth-child(odd) {
 background-color: #fff;
}
table#t01 th {
  background-color: black;
  color: white;
}
</style>
 <table width="100%" border="1" id="t01">
  <tr>
   <th>CartId</th>
   <th>ItemId</th>
   <th>Quantity</th>
  
  </tr>
  <c:forEach items="${listCartItem }" var="cartItem" >
   <tr>
    <td>${cartItem.cartId }</td>
    <td>${cartItem.itemId }</td>
    <td>${cartItem.quantity}</td>
    
   </tr>    
  </c:forEach>
 </table>
 
 <p></p> <p></p>
 <a href="/">Home</a> <p></p> <p></p>
 
</body>
</html>