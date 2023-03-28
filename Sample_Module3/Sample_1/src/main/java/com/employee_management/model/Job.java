package com.employee_management.model;

public class Job {
    int jobId;
    String jobName;
    float minSalary;
    float maxSalary;

    public Job(int jobId, String jobName, float minSalary, float maxSalary) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public int getjobId() {
        return jobId;
    }

    public void setId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public float getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(float minSalary) {
        this.minSalary = minSalary;
    }

    public float getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(float maxSalary) {
        this.maxSalary = maxSalary;
    }
}
