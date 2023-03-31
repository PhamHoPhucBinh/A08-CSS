<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: ASUS--%>
<%--  Date: 27-Mar-23--%>
<%--  Time: 7:19 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Add new Employee</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<center>--%>
<%--    <h1>Add new Employee</h1>--%>
<%--    <h2>--%>
<%--        <a href="EmployeeServlet?action=EmployeeServlet">Back to Employee List</a>--%>
<%--    </h2>--%>
<%--</center>--%>
<%--<div align="center">--%>
<%--    <form method="post">--%>
<%--        <table border="1" cellpadding="5">--%>
<%--            <caption>--%>
<%--                <h2>--%>
<%--                    Provide Employee Information !--%>
<%--                </h2>--%>
<%--            </caption>--%>
<%--            <tr>--%>
<%--                <th>Employee Name :</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="name" size="45"--%>
<%--                           value="<c:out value='${employee.name}' />"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Birthday :</th>--%>
<%--                <td>--%>
<%--                    <input type="date" name="birthday" size="45"--%>
<%--                           value="<c:out value='${employee.birthday}' />"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Address :</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="address" size="15"--%>
<%--                           value="<c:out value='${employee.address}' />"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Start Date :</th>--%>
<%--                <td>--%>
<%--                    <input type="date" name="start_date" size="15"--%>
<%--                           value="<c:out value='${employee.startDate}' />"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>End Date :</th>--%>
<%--                <td>--%>
<%--                    <input type="date" name="end_date" size="15"--%>
<%--                           value="<c:out value='${employee.endDate}' />"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Salary :</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="salary" size="15"--%>
<%--                           value="<c:out value='${employee.salary}'/>"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Job ID :</th>--%>
<%--                <td>--%>
<%--                    <select name="job_id">--%>
<%--                        <c:forEach items="${listJob}" var="job">--%>
<%--                            <option value="${job.jobId}"><c:out value="${job.jobName}"></c:out></option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td colspan="2" align="center">--%>
<%--                    <input type="submit" value="Save"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<style>
    label {
        font-weight: bold;
    }
</style>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <h1 class="text-center mt-3">Add new Employee</h1>
            <div class="text-center mb-3">
                <a href="EmployeeServlet?action=EmployeeServlet">Back to Employee List</a>
            </div>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form method="post">
                <div class="form-group">
                    <label for="name">Employee Name:</label>
                    <input type="text" class="form-control" id="name" name="name"
                           value="<c:out value='${employee.name}' />" required>
                    <div class="valid-feedback">Valid input!</div>
                    <div class="invalid-feedback">Please provide a valid input!</div>
                </div>
                <script>
                    // Get the input element
                    const input = document.getElementById('name');

                    // Add an event listener to listen for input changes
                    input.addEventListener('input', function () {
                        // Check if the input is valid
                        if (input.checkValidity()) {
                            // If it is, add the 'is-valid' class and remove the 'is-invalid' class
                            input.classList.add('is-valid');
                            input.classList.remove('is-invalid');
                        } else {
                            // If it is not, add the 'is-invalid' class and remove the 'is-valid' class
                            input.classList.add('is-invalid');
                            input.classList.remove('is-valid');
                        }
                    });
                </script>

                <div class="form-group">
                    <label for="birthday">Birthday:</label>
                    <input type="date" class="form-control" id="birthday" name="birthday"
                           value="<c:out value='${employee.birthday}' />"/>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" class="form-control" id="address" name="address"
                           value="<c:out value='${employee.address}' />"/>
                </div>
                <div class="form-group">
                    <label for="start_date">Start Date:</label>
                    <input type="date" class="form-control" id="start_date" name="start_date"
                           value="<c:out value='${employee.startDate}' />"/>
                </div>
                <div class="form-group">
                    <label for="end_date">End Date:</label>
                    <input type="date" class="form-control" id="end_date" name="end_date"
                           value="<c:out value='${employee.endDate}' />"/>
                </div>
                <div class="form-group">
                    <label for="salary">Salary:</label>
                    <input type="text" class="form-control" id="salary" name="salary"
                           value="<c:out value='${employee.salary}'/>"/>
                </div>
                <div class="form-group">
                    <%--@declare id="job_id"--%><label for="job_id">Job Position:</label>
                    <select name="job_id">
                        <c:forEach items="${listJob}" var="job">
                            <option value="${job.jobId}"><c:out value="${job.jobName}"></c:out></option>
                        </c:forEach>
                    </select>
                    <%--                    <p colspan="2" align="center">--%>
                    <%--                        <input type="submit" value="Save"/>--%>
                    <%--                    </p>--%>
                    <p colspan="2" align="center">
                        <input type="submit" value="Save" class="btn btn-success btn-lg btn-block rounded-pill"/>
                    </p>
                </div>
            </form>
        </div>
    </div>
</div>

