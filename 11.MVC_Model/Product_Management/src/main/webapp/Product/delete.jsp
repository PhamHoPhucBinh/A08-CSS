<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 21-Mar-23
  Time: 6:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product</h1>
<p>
  <a href="/ProductServlet">Back to Product List</a>
</p>
<form method="post">
    <h2>Are u sure?</h2>
    <fieldset>
        <legend>Product Information</legend>
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
                <td>Product Details: </td>
                <td>${requestScope["product"].getDetails()}</td>
            </tr>
            <tr>
                <td>Product Manufacturer: </td>
                <td>${requestScope["product"].getManufacturer()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete Product"></td>
                <td><a href="/ProductServlet">Back to Product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
