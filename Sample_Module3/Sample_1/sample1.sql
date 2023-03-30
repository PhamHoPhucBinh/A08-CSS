CREATE DATABASE your_database_name;

USE your_database_name;

CREATE TABLE job (
  job_id INT PRIMARY KEY,
  job_name VARCHAR(50) NOT NULL,
  max_salary DECIMAL(10,2) NOT NULL,
  min_salary DECIMAL(10,2) NOT NULL
);

CREATE TABLE employee (
  id INT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  birthday DATE NOT NULL,
  address VARCHAR(100) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  salary DECIMAL(10,2) NOT NULL,
  job_id INT NOT NULL,
  FOREIGN KEY (job_id) REFERENCES job(job_id)
);

INSERT INTO job (job_id, job_name, max_salary, min_salary)
VALUES 
  (1, 'Developer', 10000.0, 5000.0),
  (2, 'Designer', 8000.0, 4000.0),
  (3, 'Manager', 15000.0, 8000.0),
  (4, 'Marketing', 9000.0, 4500.0),
  (5, 'Accountant', 12000.0, 6000.0);

INSERT INTO employee (id, name, birthday, address, start_date, end_date, salary, job_id)
VALUES 
  (1, 'John Smith', '1990-02-12', '123 Main St, Anytown, USA', '2020-01-01', '2024-01-01', 8000.0, 1),
  (2, 'Jane Doe', '1995-06-23', '456 Park Ave, Anytown, USA', '2019-05-01', '2024-01-01', 7000.0, 2),
  (3, 'Bob Johnson', '1987-11-10', '789 Elm St, Anytown, USA', '2021-03-01','2024-01-01', 12000.0, 3),
  (4, 'Sarah Lee', '1992-09-08', '321 Maple St, Anytown, USA', '2018-12-01', '2024-01-01'L, 9000.0, 4),
  (5, 'David Kim', '1985-03-18', '654 Oak St, Anytown, USA', '2022-01-01', '2024-01-01', 10000.0, 5);


select * from employee;
