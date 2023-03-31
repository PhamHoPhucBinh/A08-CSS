<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<head>
    <title>Edit Employee</title>
</head>
<%--<body>--%>
<%--<h1>Edit Employee</h1>--%>
<%--<p>--%>
<%--    <c:if test='${requestScope["message"]!=null}'>--%>
<%--    <span class="message">--%>
<%--            ${requestScope["message"]}--%>
<%--    </span>--%>
<%--    </c:if>--%>
<%--</p>--%>
<%--<p>--%>
<%--    <a href="/EmployeeServlet">Back to employee list</a>--%>
<%--</p>--%>
<%--<form method="post">--%>
<%--    <fieldset>--%>
<%--        <legend>Employee information</legend>--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>Employee name:</td>--%>
<%--                <td><input type="text" name="name" id="name"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Employee birthday:</td>--%>
<%--                <td><input type="date" name="birthday" id="birthday"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Employee address:</td>--%>
<%--                <td><input type="text" name="address" id="address"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Employee Start Date:</td>--%>
<%--                <td><input type="date" name="startDate" id="start_date"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Employee End Date:</td>--%>
<%--                <td><input type="date" name="endDate" id="end_date"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Employee Salary:</td>--%>
<%--                <td><input type="number" name="salary" id="salary"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Job ID : </td>--%>
<%--                <td><input type="number" name="job_id" id="job_id"></td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td></td>--%>
<%--                <td><input type="submit" value="Update Employee"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </fieldset>--%>
<%--</form>--%>
<%--</body>--%>

<body>
<div class="container">
    <h1 class="text-center">Edit Employee</h1>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form method="post">
                <div class="form-group">
                    <label for="name">Employee name:</label>
                    <input type="text" class="form-control" name="name" id="name">
                </div>
                <div class="form-group">
                    <label for="birthday">Employee birthday:</label>
                    <input type="date" class="form-control" name="birthday" id="birthday">
                </div>
                <div class="form-group">
                    <label for="address">Employee address:</label>
                    <input type="text" class="form-control" name="address" id="address">
                </div>
                <div class="form-group">
                    <label for="start_date">Employee Start Date:</label>
                    <input type="date" class="form-control" name="start_date" id="start_date">
                </div>
                <div class="form-group">
                    <label for="end_date">Employee End Date:</label>
                    <input type="date" class="form-control" name="end_date" id="end_date">
                </div>
                <div class="form-group">
                    <label for="salary">Employee Salary:</label>
                    <input type="number" class="form-control" name="salary" id="salary">
                </div>
                <div class="form-group">
                    <%--@declare id="job_id"--%><label for="job_id">Job Postion:</label>
<%--                    <input type="number" class="form-control" name="job_id" id="job_id">--%>
                    <select name="job_id" id="job_id">
                        <c:forEach items="${listJob}" var="job">
                            <option value="${job.jobId}"><c:out value="${job.jobName}"></c:out></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Update Employee">
                </div>
            </form>
            <p class="text-center">
                <a href="/EmployeeServlet">Back to employee list</a>
            </p>
        </div>
    </div>
</div>
</body>
</html>