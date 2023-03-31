package com.employee_management.controller;

import com.employee_management.model.Employee;
import com.employee_management.model.Job;
import com.employee_management.repository.EmployeeRepository;
import com.employee_management.repository.EmployeeRepositoryImpl;
import com.employee_management.service.EmployeeService;
import com.employee_management.service.EmployeeServiceImpl;
import com.employee_management.service.JobService;
import com.employee_management.service.JobServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;
    private JobService jobService;

    public void init() {
        jobService = new JobServiceImpl();
        employeeService = new EmployeeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                case "search":
                    searchData(request,response);
                default:
                    listData(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void searchData(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        List<Employee> listEmployee = employeeService.findAll();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/search.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listJob", jobService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("employee", existingEmployee);
        request.setAttribute("listJob", jobService.findAll());
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeService.findById(id);
        RequestDispatcher dispatcher;
        request.setAttribute("employee", employee);
        dispatcher = request.getRequestDispatcher("user/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listData(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        List<Employee> listEmployee = employeeService.findAll();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    addData(request, response);
                    break;
                case "edit":
                    updateData(request, response);
                    break;
                case "delete":
                    deleteData(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void deleteData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.remove(id);
        List<Employee> listEmployee = employeeService.findAll();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void addData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        float salary = Float.parseFloat(request.getParameter("salary"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date birthday = null, startDate = null, endDate = null;
        try {
            birthday = dateFormat.parse(request.getParameter("birthday"));
            startDate = dateFormat.parse(request.getParameter("start_date"));
            endDate = dateFormat.parse(request.getParameter("end_date"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int jobId = Integer.parseInt(request.getParameter("job_id"));
        Job job = jobService.findById(jobId);
        Employee employee = new Employee(name, birthday, address, startDate, endDate, salary, job);
        employeeService.add(employee);
        response.sendRedirect("/EmployeeServlet?isCreate=1");
    }

    private void updateData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        float salary = Float.parseFloat(request.getParameter("salary"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date birthday = null, startDate = null, endDate = null;
        try {
            birthday = dateFormat.parse(request.getParameter("birthday"));
            startDate = dateFormat.parse(request.getParameter("start_date"));
            endDate = dateFormat.parse(request.getParameter("end_date"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int jobId = Integer.parseInt(request.getParameter("job_id"));
        Job job = jobService.findById(jobId);
        Employee book = new Employee(id, name, birthday, address, startDate, endDate, salary, job);
        employeeService.update(book);
        response.sendRedirect("/EmployeeServlet");
    }
}
