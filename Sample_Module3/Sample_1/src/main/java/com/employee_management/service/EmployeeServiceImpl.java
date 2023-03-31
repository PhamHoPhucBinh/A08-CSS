package com.employee_management.service;

import com.employee_management.model.Employee;
import com.employee_management.repository.EmployeeRepository;
import com.employee_management.repository.EmployeeRepositoryImpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository = new EmployeeRepositoryImpl();

    @Override
    public void add(Employee employee) {
        repository.add(employee);
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public void remove(int id) throws SQLException {
        repository.remove(id);
    }

    @Override
    public List<Employee> findByJobName(String jobName) {
        return repository.findByJobName(jobName);
    }

    @Override
    public List<Employee> findByStartDateAndEndDate(Date StartDate, Date EndDate) {
        return null;
    }
}
