<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--  <meta charset="UTF-8">--%>
<%--  <title>Delete Confirm</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Delete Confirm</h1>--%>
<%--<p>Do you want to delete this data? <%= request.getParameter("id") %> No</p>--%>
<%--<form method="post">--%>
<%--  <input type="hidden" name="id" value="<%= request.getParameter("id") %>">--%>
<%--  <input type="submit" value="Delete">--%>
<%--  <button type="button" onclick="history.back()">Cancel</button>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%--//////////////////////--%>

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
<body>
<div class="container">
  <h1>Xác nhận xóa user</h1>
  <p>Bạn có chắc chắn muốn xóa user <%= request.getParameter("id") %> không?</p>
  <form method="post">
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
    <button type="submit" class="btn btn-danger">Xóa</button>
    <a href="#" class="btn btn-default" onclick="history.back()">Hủy</a>
  </form>
</div>
</body>
</html>