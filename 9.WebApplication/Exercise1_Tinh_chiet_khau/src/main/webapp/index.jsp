<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Tính Chiết Khấu</h2>
<h3>Product Description: </h3>
<form method="post" action="/display-discount">
<input type="text" name="productDescription" placeholder="enter your product description">
<h3>List Price : </h3>
<input type="number" name="price" placeholder="enter product's price" >
<h3>Discount Percent</h3>
<input type="number" name="discount" placeholder="%">
<button name="calcualtion" type="submit" id="calculation" value="Calcuation">Calculation</button>
</form>
</body>
</html>