<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: HP--%>
<%--  Date: 29-Mar-23--%>
<%--  Time: 6:17 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Employee Management</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div>--%>
<%--    <h1>Employee Infomation</h1>--%>
<%--    <div class="search">--%>
<%--        <form action="/EmployeeServlet" method="post">--%>
<%--            <h2>Search Employee</h2>--%>
<%--            <input type="text" name="job_name" placeholder="searching for job name">--%>
<%--            <input type="submit" value="search" name="action">--%>
<%--        </form>--%>
<%--    </div>--%>
<%--    <table>--%>
<%--        <c:forEach var="s" items="${job_id}">--%>
<%--            <tr>--%>

<%--                <th>${s.id}</th>--%>
<%--                <th>${s.name}</th>--%>
<%--                <th>${s.birthday}</th>--%>
<%--                <th>${s.address}</th>--%>
<%--                <th>${s.startDate}</th>--%>
<%--                <th>${s.endDate}</th>--%>
<%--                <th>${s.salary}</th>--%>
<%--                <th>${s.job}</th>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>
<%--<div>--%>
<%--    <h2>--%>
<%--        <a href="/EmployeeServlet?action=create">add new employee</a>--%>
<%--        <br>--%>
<%--        <a href="/EmployeeServlet">refresh</a>--%>
<%--    </h2>--%>
<%--</div>--%>
<%--<div align="center">--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <caption><h2>List of Employee</h2></caption>--%>
<%--        <tr>--%>
<%--            <th>Id</th>--%>
<%--            <th>Name</th>--%>
<%--            <th>Birthday</th>--%>
<%--            <th>Address</th>--%>
<%--            <th>Start Date</th>--%>
<%--            <th>End Date</th>--%>
<%--            <th>Salary</th>--%>
<%--            <th>Job Id</th>--%>
<%--            <th>Job Name</th>--%>
<%--            <th>Edit</th>--%>
<%--            <th>Delete</th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${listEmployee}" var="employee">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${employee.id}"/></td>--%>
<%--                <td><c:out value="${employee.name}"/></td>--%>
<%--                <td><fmt:formatDate value="${employee.birthday}" pattern="dd/MM/yyyy"/></td>--%>
<%--                <td><c:out value="${employee.address}"/></td>--%>
<%--                <td><fmt:formatDate value="${employee.startDate}" pattern="dd/MM/yyyy"/></td>--%>
<%--                <td><fmt:formatDate value="${employee.endDate}" pattern="dd/MM/yyyy"/></td>--%>
<%--                <td><fmt:formatNumber value="${employee.salary}" pattern="###,###"/></td>--%>
<%--                <td><c:out value="${employee.job.jobId}"/></td>--%>
<%--                <td><c:out value="${employee.job.jobName}"/></td>--%>
<%--                <td>--%>
<%--                    <a href="/EmployeeServlet?action=edit&id=${employee.id}">Edit</a></td>--%>
<%--                <td>--%>
<%--                    <a href="/EmployeeServlet?action=delete&id=${employee.id}">Delete</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>


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
    <title>Employee Management</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Add jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Add Popper.js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Add Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Add custom style -->
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
    <h1 class="header">Employee Infomation</h1>
    <div class="search">
        <form action="/EmployeeServlet?action=search" method="get">
            <h2>Search Employee</h2>
            <input type="text" name="job_name" placeholder="searching for job name">
            <input type="submit" value="search" name="action">
        </form>
    </div>
    <table class="table">
        <c:forEach var="s" items="${job_id}">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.birthday}</td>
                <td>${s.address}</td>
                <td>${s.startDate}</td>
                <td>${s.endDate}</td>
                <td>${s.salary}</td>
                <td>${s.job}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="container">
        <a href="/EmployeeServlet?action=create" class="btn btn-success btn-lg" style="float: left">ADD</a>
        <a href="/EmployeeServlet" class="btn btn-warning btn-lg" style="float: right">Refresh</a>
    </div>
    <table class="table">
        <thead style="color: red">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Salary</th>
            <th>Job Name</th>
        </tr>
        </thead>
        <c:forEach items="${listEmployee}" var="employee">
            <tr>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.name}"/></td>
                <td><fmt:formatDate value="${employee.birthday}" pattern="dd/MM/yyyy"/></td>
                <td><c:out value="${employee.address}"/></td>
                <td><fmt:formatDate value="${employee.startDate}" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatDate value="${employee.endDate}" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatNumber value="${employee.salary}" pattern="###,###"/></td>
                <td><c:out value="${employee.job.jobName}"/></td>
                <td>
                    <a href="/EmployeeServlet?action=edit&id=${employee.id}">Edit</a></td>
                <td>
                    <a href="/EmployeeServlet?action=delete&id=${employee.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>