package com.employee_management.repository;

import com.employee_management.model.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.employee_management.utility.ConnectionUtil.getConnection;

public class JobRepositoryImpl implements JobRepository {
    private static final String SELECT_ALL_JOB = "Select * from job";
    private static final String SELECT_JOB_BY_ID = "Select * from job where job_id = ?";


    @Override
    public Job findById(int jobId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_JOB_BY_ID)) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, jobId);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String jobName = rs.getString("job_name");
                float minSalary = rs.getFloat("min_salary");
                float maxSalary = rs.getFloat("max_salary");
                return new Job(jobId, jobName,minSalary,maxSalary);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }

    @Override
    public List<Job> findAll() {
        List<Job> jobList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_JOB)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int jobID = rs.getInt("job_id");
                String jobName = rs.getString("job_name");
                float minSalary = rs.getFloat("min_salary");
                float maxSalary = rs.getFloat("max_salary");
                jobList.add(new Job(jobID,jobName,minSalary,maxSalary));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return jobList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
