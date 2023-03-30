<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 27-Mar-23
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Employee</title>
</head>
<body>
<center>
    <h1>Add new Employee</h1>
    <h2>
        <a href="EmployeeServlet?action=EmployeeServlet">Back to Employee List</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Provide Employee Information !
                </h2>
            </caption>
            <tr>
                <th>Employee Name :</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${employee.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Birthday :</th>
                <td>
                    <input type="date" name="birthday" size="45"
                           value="<c:out value='${employee.birthday}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address :</th>
                <td>
                    <input type="text" name="address" size="15"
                           value="<c:out value='${employee.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Start Date :</th>
                <td>
                    <input type="date" name="start_date" size="15"
                           value="<c:out value='${employee.startDate}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>End Date :</th>
                <td>
                    <input type="date" name="end_date" size="15"
                           value="<c:out value='${employee.endDate}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Salary :</th>
                <td>
                    <input type="text" name="salary" size="15"
                           value="<c:out value='${employee.salary}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Job ID :</th>
                <td>
                    <select name="job_id">
                        <c:forEach items="${listJob}" var="job">
                            <option value="${job.jobId}"><c:out value="${job.jobName}"></c:out></option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
