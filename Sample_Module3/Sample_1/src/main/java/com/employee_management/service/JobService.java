package com.employee_management.service;

import com.employee_management.model.Job;

import java.util.List;

public interface JobService {
    Job findById(int jobId);
    List<Job> findAll();
}
