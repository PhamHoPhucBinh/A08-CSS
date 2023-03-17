<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 15-Mar-23
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/customers?action=create">Create new Customer</a>
</p>
<p><input type="number" name="id" id="ipSearch"></p>
<button onclick="fcSearch()">Search</button>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${customers}' var="customer">
        <tr>
            <td>${customer.id}</td>
            <td><a href="/customers?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customers?action=edit&id=${customer.getId()}">edit</a></td>
            <td><a href="/customers?action=delete&id=${customer.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>

<script>
    function fcSearch(){
        // alert("id= " + document.getElementById('ipSearch').value);
        location.href = "/customers?id=" + document.getElementById('ipSearch').value;
    }
</script>
</body>
</html>
