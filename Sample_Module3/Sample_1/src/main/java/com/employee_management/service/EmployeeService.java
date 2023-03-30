package com.employee_management.service;

import com.employee_management.model.Employee;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface EmployeeService {
    void add(Employee employee);
    boolean update(Employee employee);
    Employee findById( int id);
    List<Employee> findAll();
    void remove(int id) throws SQLException;
    List<Employee> findByJobName(String jobName);
    List<Employee> findByStartDateAndEndDate(Date StartDate, Date EndDate);

}
