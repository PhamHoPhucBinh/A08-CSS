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
    <title>Add New Customer</title>
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
            <h1 class="text-center mt-3">Add new Customer</h1>
            <div class="text-center mb-3">
                <a href="CustomerServlet?action=CustomerServlet">Back to Customer List</a>
            </div>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form method="post">
                <div class="form-group">
                    <label for="customerName">Customer Name:</label>
                    <input onkeydown="check('customerName')" type="text" class="form-control" id="customerName" name="customerName"
                           value="<c:out value='${customer.customerName}' />" required>
                    <div class="valid-feedback">Valid input!</div>
                    <div class="invalid-feedback">Please provide a valid input!</div>
                </div>
                <div class="form-group">
                    <label for="birthday">Birthday:</label>
                    <input oninput="check('birthday')" type="date" class="form-control" id="birthday" name="birthday"
                           value="<c:out value='${customer.birthday}' />" required>
                    <div class="valid-feedback">Valid input!</div>
                    <div class="invalid-feedback">Please provide a valid input!</div>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input onkeydown="check('address')" type="text" class="form-control" id="address" name="address"
                           value="<c:out value='${customer.address}' />" required>
                    <div class="valid-feedback">Valid input!</div>
                    <div class="invalid-feedback">Please provide a valid input!</div>
                </div>
                <div class="form-group">
                    <label for="phone">Phone Number:</label>
                    <input onkeydown="check('phone')" type="text" class="form-control" id="phone" name="phone"
                           value="<c:out value='${customer.phone}' />" required>
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
