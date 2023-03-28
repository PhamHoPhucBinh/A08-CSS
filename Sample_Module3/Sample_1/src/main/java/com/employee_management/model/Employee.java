package com.employee_management.model;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private Date birthday;
    private String address;
    private Date startDate;
    private Date endDate;
    private float salary;
    private Job jobID;

    public Employee(int id, String name, Date birthday, String address, Date startDate, Date endDate, float salary, Job jobID) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.jobID = jobID;
    }

    public Employee(String name, Date birthday, String address, Date startDate, Date endDate, float salary, Job jobID) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.jobID = jobID;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Job getJobID() {
        return jobID;
    }

    public void setJobID(Job jobID) {
        this.jobID = jobID;
    }
}
