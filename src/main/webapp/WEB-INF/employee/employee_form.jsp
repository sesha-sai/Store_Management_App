<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
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
 <spring:url value="/employee/save" var="saveURL" />
 <form:form modelAttribute="employeeForm" method="post" action="${saveURL }" >
  <form:hidden path="employeeId"/>
  <table>
   <tr>
    <td>Name: </td>
    <td>
     <form:input path="name"/>
    </td>
   </tr>
   
   <tr>
    <td>PhoneNo: </td>
    <td>
     <form:input path="phoneNo"/>
    </td>
   </tr>
   
   <tr>
    <td>Address: </td>
    <td>
     <form:input path="address"/>
    </td>
   </tr>
   
   <tr>
    <td>MonthlyWage: </td>
    <td>
     <form:input path="monthlyWage"/>
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