<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Form</title>
</head>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body><div align="center">
 <spring:url value="/item/save" var="saveURL" />
 <form:form modelAttribute="itemForm" method="post" action="${saveURL }" >
  <form:hidden path="itemId"/>
  <table>
   <tr>
    <td>Name: </td>
    <td>
     <form:input path="name"/>
    </td>
   </tr>
   
   <tr>
    <td>Size: </td>
    <td>
     <form:input path="size"/>
    </td>
   </tr>
   
   <tr>
    <td>BrandId: </td>
    <td>
     <form:input path="brandId"/>
    </td>
   </tr>
   
   <tr>
    <td>BuyingPrice: </td>
    <td>
     <form:input path="buyingPrice"/>
    </td>
   </tr>
   
   <tr>
    <td>SellingPrice: </td>
    <td>
     <form:input path="sellingPrice"/>
    </td>
   </tr>
   
   <tr>
    <td>Colour: </td>
    <td>
     <form:input path="colour"/>
    </td>
   </tr>
   
   <tr>
    <td>Quantity: </td>
    <td>
     <form:input path="quantity"/>
    </td>
   </tr>
   
   <tr>
    <td></td>
    <td>
     <button type="submit">Save</button>
    </td>
   </tr>
  </table>
  
 </form:form>
 </div>
</body>
</html>