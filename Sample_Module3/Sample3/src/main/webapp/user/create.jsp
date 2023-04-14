<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 27-Mar-23
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Order</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<style>
    label {
        font-weight: bold;
    }
    body {
        background-image: url("https://img.freepik.com/free-vector/gradient-hexagonal-background_23-2148932756.jpg?w=996&t=st=1680235792~exp=1680236392~hmac=00eeb5556276b7e64d7683f45ae997d7721bb54b40828bf1ecc215ea66cad60a");
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <h1 class="text-center mt-3">Add New Order</h1>
            <div class="text-center mb-3">
                <a href="OrderServlet?action=OrderServlet">Back to Order List</a>
            </div>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form method="post">
                <div class="form-group">
                    <label for="orderDate">Order Date:</label>
                    <input oninput="check('orderDate')" type="date" class="form-control" id="orderDate" name="orderDate"
                           value="<c:out value='${order.orderDate}' />" required>
                    <div class="valid-feedback">Valid input!</div>
                    <div class="invalid-feedback">Please provide a valid input!</div>
                </div>
                <div class="form-group">
                    <%--@declare id="productId"--%><label for="productId">Product Name:</label>
                    <select name="productId">
                        <c:forEach items="${productList}" var="product">
                            <option value="${product.productId}"><c:out value="${product.productName}"></c:out></option>
                        </c:forEach>
                    </select>
                </div>
<%--                <div class="form-group">--%>
<%--                    <label for="productId">Product ID:</label>--%>
<%--                    <input onkeydown="check('productId')" type="number" class="form-control" id="productId" name="productId"--%>
<%--                           value="<c:out value='${order.product.productId}' />" required>--%>
<%--                    <div class="valid-feedback">Valid input!</div>--%>
<%--                    <div class="invalid-feedback">Please provide a valid input!</div>--%>
<%--                </div>--%>
                <div class="form-group">
                    <label for="quantity">Quantity:</label>
                    <input onkeydown="check('quantity')" type="number" class="form-control" id="quantity" name="quantity"
                           value="<c:out value='${order.quantity}' />" required>
                    <div class="valid-feedback">Valid input!</div>
                    <div class="invalid-feedback">Please provide a valid input!</div>
                </div>
                <div class="form-group">
                    <p colspan="2" align="center">
                        <input type="submit" value="Save" class="btn btn-success btn-lg btn-block rounded-pill"/>
                    </p>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function check(id) {
        const input = document.getElementById(id);
        if (input.checkValidity()) {
            input.classList.add('is-valid');
            input.classList.remove('is-invalid');
        } else {
            input.classList.add('is-invalid');
            input.classList.remove('is-valid');
        }
    }
</script>