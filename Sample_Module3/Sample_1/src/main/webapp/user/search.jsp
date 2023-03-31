<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 31-Mar-23
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Search Results</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.1/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <h1 class="text-center mb-4">Search Results</h1>
  <form class="mb-4">
    <div class="row g-2 mt-3">
    </div>
  </form>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Birthday</th>
      <th>Address</th>
      <th>Start Date</th>
      <th>End Date</th>
      <th>Salary</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${searchJobName}">
      <tr>
        <td>${s.id}</td>
        <td>${s.name}</td>
        <td><fmt:formatDate value="${s.birthday}" pattern="dd/MM/yyyy"/></td>
        <td>${s.address}</td>
        <td><fmt:formatDate value="${s.startDate}" pattern="dd/MM/yyyy"/></td>
        <td><fmt:formatDate value="${s.endDate}" pattern="dd/MM/yyyy"/></td>
        <td>${s.salary}</td>
        <td>${s.job}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<!-- Bootstrap JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>
</body>
</html>
