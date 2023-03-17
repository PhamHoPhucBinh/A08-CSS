<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 17-Mar-23
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Infomation</title>
</head>
<body>
<h1>Customer Infomation</h1>
<table>
  <tr>
    <td>Name: </td>
    <td>${requestScope["customer"].getName()}</td>
  </tr>
  <tr>
    <td>Email:</td>
    <td>${requestScope["customer"].getEmail()}</td>
  </tr>
  <tr>
    <td>Address</td>
    <td>${requestScope["customer"].getAddress()}</td>
  </tr>
</table>
<p>
  <a href="/customers">Back to Customer list</a>
</p>
</body>
</html>
