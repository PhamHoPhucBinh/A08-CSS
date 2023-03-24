<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2023-03-17
  Time: 7:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create</title>
</head>
<body>
<h1>Create student</h1>
<form action="/ProductServlet" method="post">
  <table>
    <tr>
      <td>ID</td>
      <td><input type="text" name="id" /></td>
    </tr>
    <tr>
      <td>Name</td>
      <td><input type="text" name="name" /></td>
    </tr>
    <tr>
      <td>Price</td>
      <td><input type="text" name="price"></td>
    </tr>
    <tr>
      <td>Status</td>
      <td><input type="text" name="status"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Register"></td>
    </tr>
  </table>
  <input type="hidden" name="action" value="create">
</form>
</body>
</html>