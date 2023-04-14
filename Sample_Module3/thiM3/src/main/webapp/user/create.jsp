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
    <title>Add New Product</title>
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
            <h1 class="text-center mt-3">Add New Product</h1>
            <div class="text-center mb-3">
                <a href="ProductServlet?action=ProductServlet">Back to Product List</a>
            </div>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form method="post">
                <div class="form-group">
                    <label for="productName">Product Name:</label>
                    <input onkeydown="check('productName')" type="text" class="form-control" id="productName"
                           name="productName"
                           value="<c:out value='${product.productName}' />" required>
                    <div class="valid-feedback">Valid input!</div>
                    <div class="invalid-feedback">Please provide a valid input!</div>
                </div>
                <div class="form-group">
                    <label for="productPrice">Product Price:</label>
                    <input onkeydown="check('productPrice')" type="number" class="form-control" id="productPrice"
                           name="productPrice"
                           value="<c:out value='${product.productPrice}' />" required>
                    <div class="valid-feedback">Valid input!</div>
                    <div class="invalid-feedback">Please provide a valid input!</div>
                </div>
                <div class="form-group">
                    <label for="quantity">Quantity:</label>
                    <input onkeydown="check('phone')" type="number" class="form-control" id="quantity" name="quantity"
                           value="<c:out value='${product.quantity}' />" required>
                    <div class="valid-feedback">Valid input!</div>
                    <div class="invalid-feedback">Please provide a valid input!</div>
                </div>
<%--                    <div class="form-group">--%>
<%--                        <label for="color">Color:</label>--%>
<%--                        <input onkeydown="check('color')" type="text" class="form-control" id="color" name="color"--%>
<%--                               value="<c:out value='${product.color}' />" required>--%>
<%--                        <div class="valid-feedback">Valid input!</div>--%>
<%--                        <div class="invalid-feedback">Please provide a valid input!</div>--%>
<%--                    </div>--%>
                <div class="form-group">
                    <label for="color">Color:</label>
                    <select class="form-control" id="color" name="color" required>
                        <option value="blue" <c:if test="${product.color == 'blue'}">selected</c:if>>Blue</option>
                        <option value="red" <c:if test="${product.color == 'red'}">selected</c:if>>Red</option>
                        <option value="yellow" <c:if test="${product.color == 'yellow'}">selected</c:if>>Yellow</option>
                    </select>
                    <div class="valid-feedback">Valid input!</div>
                    <div class="invalid-feedback">Please provide a valid input!</div>
                </div>

                <div class="form-group">
                    <%--@declare id="categoryId"--%><label for="categoryId">Category:</label>
                    <select name="categoryId">
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.categoryId}"><c:out
                                    value="${category.manufacturerName}"></c:out></option>
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
