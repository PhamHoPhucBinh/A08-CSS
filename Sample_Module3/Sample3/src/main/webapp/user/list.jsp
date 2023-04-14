<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 29-Mar-23
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Management</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Add jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Add Popper.js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Add Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Add custom style -->
    <link rel="stylesheet" href="webjars/izitoast/1.4.0/dist/css/iziToast.min.css">
    <style>
        body {
            background-image: url("https://img.freepik.com/free-vector/gradient-hexagonal-background_23-2148932756.jpg?w=996&t=st=1680235792~exp=1680236392~hmac=00eeb5556276b7e64d7683f45ae997d7721bb54b40828bf1ecc215ea66cad60a");
            background-repeat: no-repeat;
            background-size: cover;
        }
        .header {
            font-family: Broadway, sans-serif;
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px;
            color: coral;
        }
        table tr:hover {
            background-color: cyan;
        }
    </style>
</head>
<body>


<div class="container">
    <h1 class="header">Order Infomation</h1>
    <div class="search">
        <form action="/OrderServlet?action=search" method="get">
            <h2>Search Order</h2>
            <input type="text" name="order" id="productName" placeholder="searching for product name">
            <input type="submit" value="search" name="action">
        </form>
    </div>
    <div class="container">
        <a href="/OrderServlet?action=create" class="btn btn-success btn-lg" style="float: left">ADD</a>
        <a href="/OrderServlet" class="btn btn-warning btn-lg" style="float: right">Refresh</a>
    </div>
    <table class="table">
        <thead style="color: red">
        <tr>
            <th>Order ID</th>
            <th>Order Date</th>
            <th>Product Name</th>
            <th>Quantity</th>
        </tr>
        </thead>
        <c:forEach items="${orderList}" var="order">
            <tr>
                <td><c:out value="${order.orderId}"/></td>
                <td><fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy"/></td>
                <td><c:out value="${order.product.productName}"/></td>
                <td><c:out value="${order.quantity}"/></td>
                <td>
                    <div class="container">
                        <a href="/OrderServlet?action=update&orderId=${order.orderId}" class="btn btn-primary btn-lg ">Update</a>
                    </div>
                </td>
                <td>
                    <div>
                        <a href="/OrderServlet?action=delete&orderId=${order.orderId}" class="btn btn-danger ">Delete</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<script src="webjars/izitoast/1.4.0/dist/js/iziToast.min.js" type="text/javascript"></script>
<c:set var="result" value='<%=request.getParameter("isCreate") %>'/>
<c:if test="${result > 0}">
    <script>
        iziToast.success({
            position: "topLeft", message: "Create Successfully!"
        });
    </script>
</c:if>
</body>
</html>