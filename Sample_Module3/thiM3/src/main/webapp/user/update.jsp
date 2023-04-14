<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<head>
    <title>Update Product</title>
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
    <h1 class="text-center">Edit Product</h1>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form method="post">
                <div class="form-group">
                    <label for="productName">Product name:</label>
                    <input type="text" class="form-control" name="productName" id="productName">
                </div>
                <div class="form-group">
                    <label for="productPrice">Product Price:</label>
                    <input type="number" class="form-control" name="productPrice" id="productPrice">
                </div>
                <div class="form-group">
                    <label for="quantity">Quantity:</label>
                    <input type="number" class="form-control" name="quantity" id="quantity">
                </div>
                <div class="form-group">
                    <label for="color">Color:</label>
                    <input type="text" class="form-control" name="color" id="color">
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
            <p class="text-center">
                <a href="/ProductServlet">Back to Product list</a>
            </p>
        </div>
    </div>
</div>
</body>
</html>
