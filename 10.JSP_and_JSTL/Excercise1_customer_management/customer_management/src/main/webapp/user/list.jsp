<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>BirthDay</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach items="${ListCustomer}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.dayOfBirth}</td>
            <td>${c.address}</td>
            <td>${c.image}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>