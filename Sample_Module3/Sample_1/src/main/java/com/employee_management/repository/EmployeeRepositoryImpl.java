package com.employee_management.repository;

import com.employee_management.model.Employee;
import com.employee_management.model.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.employee_management.utility.ConnectionUtil.getConnection;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private JobRepository jobRepository = new JobRepositoryImpl();

    private static final String SELECT_ALL_EMPLOYEE = "select *\n" + "from employee \n";
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee( name , birthday, address, " + "start_date, end_date, salary, job_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set name = ?,birthday= ?, address =?,start_date =?,end_date=?,salary=?,job_id where id = ?;";
    private static final String SELECT_EMPLOYEE_BY_ID = "select id,name,birthday,address,start_date,end_date,salary,job_id from employee where id =?";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where id = ?;";
    //    private static final String SEARCH_ALL_JOB_NAME = "select * \n" + "from employee as employee join job on employee.job_id =job.job_id\n" + "where job_name like ? ";
    private static final String SEARCH_ALL_JOB_NAME = "select * \n" + "from employee as e join job j on e.job_id =j.job_id\n" + "where job_name like ? ";

    @Override
    public void add(Employee employee) {
        System.out.println(INSERT_EMPLOYEE_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
//            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, new java.sql.Date(employee.getBirthday().getTime()));
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setDate(4, new java.sql.Date(employee.getStartDate().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(employee.getEndDate().getTime()));
            preparedStatement.setFloat(6, employee.getSalary());
            preparedStatement.setInt(7, employee.getJob().getjobId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean update(Employee employee) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
            statement.setString(1, employee.getName());
            statement.setDate(2, new java.sql.Date(employee.getBirthday().getTime()));
            statement.setString(3, employee.getAddress());
            statement.setDate(4, new java.sql.Date(employee.getStartDate().getTime()));
            statement.setDate(5, new java.sql.Date(employee.getEndDate().getTime()));
            statement.setFloat(6, employee.getSalary());
            statement.setInt(7, employee.getJob().getjobId());
            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date birthday = new Date(rs.getDate("birthday").getTime());
                String address = rs.getString("address");
                Date startDate = new Date(rs.getDate("start_date").getTime());
                Date endDate = new Date(rs.getDate("end_date").getTime());
                float salary = rs.getFloat("salary");
                int jobId = rs.getInt("job_id");
                Job job = jobRepository.findById(jobId);
                employeeList.add(new Employee(id, name, birthday, address, startDate, endDate, salary, job));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeeList;
    }

    @Override
    public List<Employee> findByJobName(String jobName) {

        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ALL_JOB_NAME)) {
            preparedStatement.setString(1, jobName + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date birthday = new Date(rs.getDate("birthday").getTime());
                String address = rs.getString("address");
                Date startDate = new Date(rs.getDate("start_date").getTime());
                Date endDate = new Date(rs.getDate("end_date").getTime());
                float salary = rs.getFloat("salary");
                int jobId = rs.getInt("job_id");
                Job job = jobRepository.findById(jobId);
                employeeList.add(new Employee(id, name, birthday, address, startDate, endDate, salary, job));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeeList;

    }

    @Override
    public List<Employee> findByStartDateAndEndDate(Date StartDate, Date EndDate) {
        return null;
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

    public Employee findById(int id) {
        Employee employee = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                float salary = rs.getFloat("salary");
                int jobId = rs.getInt("job_id");
                Job job = jobRepository.findById(jobId);
                employee = new Employee(id, name, birthday, address, startDate, endDate, salary, job);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    @Override
    public boolean remove(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

}
