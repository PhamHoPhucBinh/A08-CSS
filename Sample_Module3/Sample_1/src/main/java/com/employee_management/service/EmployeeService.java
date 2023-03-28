package com.employee_management.service;

import com.employee_management.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    void add(Employee employee);
    void update(Employee employee);
    List<Employee> findAll();
    List<Employee> findByJobName(String tenCongViec);
    List<Employee> findByStartDateAndEndDate(Date ngayBatDauLam, Date ngayKetThucLam);
}
