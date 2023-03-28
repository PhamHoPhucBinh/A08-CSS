package com.employee_management.repository;

import com.employee_management.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository {
    void add(Employee employee);
    boolean update(Employee employee);
    List<Employee> findAll();
    List<Employee> findByJobName(String jobName);
    List<Employee> findByStartDateAndEndDate(Date StartDate, Date EndDate);
}
