<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 21-Mar-23
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<p>
    <c:if test='${requestScope["message"]!=null}'>
    <span class="message">
            ${requestScope["message"]}
    </span>
    </c:if>
</p>
<p>
    <a href="/ProductServlet">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Product name:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Product price:</td>
                <td><input type="number" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Product details:</td>
                <td><input type="text" name="details" id="details"></td>
            </tr>
            <tr>
                <td>Product Manufacturer:</td>
                <td><input type="text" name="manufacturer" id="manufacturer"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
