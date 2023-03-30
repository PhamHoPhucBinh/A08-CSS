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
</head>
<body>
<div>
    <h1>Employee Infomation</h1>
    <div class="search">
        <form action="/EmployeeServlet" method="post">
            <h2>Search Employee</h2>
            <input type="text" name="job_name" placeholder="searching for job name">
            <input type="submit" value="search" name="action">
        </form>
    </div>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Salary</th>
            <th>Job Position</th>
        </tr>
        <c:forEach var="s" items="${job_id}">
            <tr>

                <th>${s.id}</th>
                <th>${s.name}</th>
                <th>${s.birthday}</th>
                <th>${s.address}</th>
                <th>${s.startDate}</th>
                <th>${s.endDate}</th>
                <th>${s.salary}</th>
                <th>${s.job}</th>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <h2>
        <a href="/EmployeeServlet?action=create">add new employee</a>
        <br>
        <a href="/EmployeeServlet">refresh</a>
    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Employee</h2></caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Salary</th>
            <th>Job Id</th>
            <th>Job Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${listEmployee}" var="employee">
            <tr>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.name}"/></td>
                <td><fmt:formatDate value="${employee.birthday}" pattern="dd/MM/yyyy"/></td>
                <td><c:out value="${employee.address}"/></td>
                <td><fmt:formatDate value="${employee.startDate}" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatDate value="${employee.endDate}" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatNumber value="${employee.salary}" pattern="###,###"/></td>
                <td><c:out value="${employee.job.jobId}"/></td>
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
</body>
</html>
