<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 17-Mar-23
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Customer Info</title>
</head>
<body>
<h1> Update Customer Info </h1>
<p>
    <c:if test='${requestScope["message"]!=null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/customers">Back to Customer List</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer Info</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" value="${requestScope["customer"].getName()}"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id="email" value="${requestScope["customer"].getEmail()}"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="address" name="address" id="address" value="${requestScope["customer"].getAddress()}">
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
