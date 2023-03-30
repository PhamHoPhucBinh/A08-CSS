<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<h1>Edit Employee</h1>
<p>
    <c:if test='${requestScope["message"]!=null}'>
    <span class="message">
            ${requestScope["message"]}
    </span>
    </c:if>
</p>
<p>
    <a href="/EmployeeServlet">Back to employee list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Employee information</legend>
        <table>
            <tr>
                <td>Employee name:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Employee birthday:</td>
                <td><input type="number" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Employee address:</td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td>Employee Start Date:</td>
                <td><input type="text" name="startDate" id="start_date"></td>
            </tr>
            <tr>
                <td>Employee End Date:</td>
                <td><input type="text" name="endDate" id="end_date"></td>
            </tr>
            <tr>
                <td>Employee Salary:</td>
                <td><input type="text" name="endDate" id="salary"></td>
            </tr>
            <tr>
                <td>Job ID : </td>
                <td><input type="text" name="job_id" id="job_id"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Update Employee"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>