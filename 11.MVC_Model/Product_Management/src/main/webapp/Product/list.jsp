<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 21-Mar-23
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>listProduct</title>
</head>
<body>
<h1>Products List</h1>
<p>
    <a href="/ProductServlet?action=create">Create new Product</a>
</p>
<fieldset>
    <table border="1">
        <tr>
            <td>Product Name:</td>
            <td>Product Price:</td>
            <td>Product Detail</td>
            <td>Product Manufactor</td>
            <td>Edit</td>
            <td>Del</td>
        </tr>
        <c:forEach items='${requestScope["products"]}' var="product">
            <tr>
                <td><a href="/ProductServlet?action=view&id=${product.getId()}">${product.getName()}</a></td>
                <td>${product.getPrice()}</td>
                <td>${product.getDetails()}</td>
                <td>${product.getManufactor()}</td>
                <td><a href="/ProductServlet?action=edit?id=${product.getId()}">Edit</a></td>
                <td><a href="/ProductServlet?action=delete?id=${product.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</fieldset>
</body>
</html>
