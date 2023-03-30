package com.employee_management.repository;

import com.employee_management.model.Employee;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository {
    void add(Employee employee);

    boolean update(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    boolean remove(int id) throws SQLException;

    List<Employee> findByJobName(String jobName);

    List<Employee> findByStartDateAndEndDate(Date StartDate, Date EndDate);


}
