<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xác nhận xóa user</title>
    <!-- Thêm CSS của Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Thêm thư viện jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Thêm thư viện JavaScript của Bootstrap -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
    <h1>Xác nhận xóa user</h1>
    <p>Bạn có chắc chắn muốn xóa user <%= request.getParameter("orderId") %> không?</p>
    <form method="post">
        <input type="hidden" name="orderId" value="<%= request.getParameter("orderId") %>">
        <button type="submit" class="btn btn-danger">Xóa</button>
        <a href="#" class="btn btn-default" onclick="history.back()">Hủy</a>
    </form>
</div>
</body>
</html>