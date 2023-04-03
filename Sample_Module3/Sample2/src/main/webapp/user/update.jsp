<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<head>
    <title>Update Customer</title>
</head>
<style>
    body {
        background-image: url("https://img.freepik.com/free-vector/gradient-hexagonal-background_23-2148932756.jpg?w=996&t=st=1680235792~exp=1680236392~hmac=00eeb5556276b7e64d7683f45ae997d7721bb54b40828bf1ecc215ea66cad60a");
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<body>
<div class="container">
    <h1 class="text-center">Edit customer</h1>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form method="post">
                <div class="form-group">
                    <label for="customerName">Customer name:</label>
                    <input type="text" class="form-control" name="customerName" id="customerName">
                </div>
                <div class="form-group">
                    <label for="birthday">Customer birthday:</label>
                    <input type="date" class="form-control" name="birthday" id="birthday">
                </div>
                <div class="form-group">
                    <label for="address">Customer address:</label>
                    <input type="text" class="form-control" name="address" id="address">
                </div>
                <div class="form-group">
                    <label for="phone">Customer Phone:</label>
                    <input type="text" class="form-control" name="phone" id="phone">
                </div>
                <div class="form-group">
                    <%--@declare id="productId"--%><label for="productId">Product Name:</label>
                    <select name="productId">
                        <c:forEach items="${productList}" var="product">
                            <option value="${product.productId}"><c:out value="${product.productName}"></c:out></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Update Customer">
                </div>
            </form>
            <p class="text-center">
                <a href="/CustomerServlet">Back to customer list</a>
            </p>
        </div>
    </div>
</div>
</body>
</html>
