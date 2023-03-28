package com.employee_management.service;

import com.employee_management.model.Employee;
import com.employee_management.repository.EmployeeRepository;
import com.employee_management.repository.EmployeeRepositoryImpl;

import java.util.Date;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository repository = new EmployeeRepositoryImpl();
    @Override
    public void add(Employee employee) {

    }

    @Override
    public void update(Employee employee) {
        repository.update(employee);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Employee> findByJobName(String jobName) {
        return repository.findByJobName(jobName);
    }

    @Override
    public List<Employee> findByStartDateAndEndDate(Date startDate, Date endDate) {
        return repository.findByStartDateAndEndDate(startDate, endDate);
    }
}
