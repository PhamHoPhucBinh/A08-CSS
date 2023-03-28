package com.employee_management.service;

import com.employee_management.model.Job;
import com.employee_management.repository.JobRepository;
import com.employee_management.repository.JobRepositoryImpl;

import java.util.List;

public class JobServiceImpl implements JobService {
    private JobRepository repository = new JobRepositoryImpl();
    @Override
    public Job findById(int jobId) {
        return repository.findById(jobId);
    }

    @Override
    public List<Job> findAll() {
        return repository.findAll();
    }
}
