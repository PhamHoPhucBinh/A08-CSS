<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
  <a href="/ProductServlet">Back to product list</a>
</p>
<table>
  <tr>
    <td>Product Name: </td>
    <td>${requestScope["product"].getName()}</td>
  </tr>
  <tr>
    <td>Product Price: </td>
    <td>${requestScope["product"].getPrice()}</td>
  </tr>
  <tr>
    <td>Product Detail: </td>
    <td>${requestScope["product"].getDetails()}</td>
  </tr>
  <tr>
    <td>Product Manufacturer: </td>
    <td>${requestScope["product"].getManufacturer()}</td>
  </tr>
</table>
</body>
</html>