<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Page</title>
</head>
<body>
 <spring:url value="/item/add" var="addURL" />
 <a href="${addURL }">Add Item</a>

 <h1>Item List</h1>
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
   <th>ItemId</th>
   <th>Name</th>
   <th>Size</th>
   <th>BrandId</th>
   <th>BuyingPrice</th>
   <th>SellingPrice</th>
   <th>Colour</th>
   <th>Quantity</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listItem }" var="item" >
   <tr>
    <td>${item.itemId }</td>
    <td>${item.name }</td>
    <td>${item.size}</td>
    <td>${item.brandId}</td>
    <td>${item.buyingPrice}</td>
    <td>${item.sellingPrice}</td>
    <td>${item.colour}</td>
    <td>${item.quantity}</td>
    <td>
     <spring:url value="/item/update/${item.itemId }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/item/delete/${item.itemId }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
 <p></p> <p></p>
 <a href="/">Home</a> <p></p> <p></p>
 
</body>
</html>