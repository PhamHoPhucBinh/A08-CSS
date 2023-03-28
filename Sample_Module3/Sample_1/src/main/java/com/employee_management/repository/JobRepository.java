package com.employee_management.repository;

import com.employee_management.model.Job;

import java.util.List;

public interface JobRepository {
    Job findById(int jobId);
    List<Job> findAll();
}

