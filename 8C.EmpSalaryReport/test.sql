-- 1. Create the database (if not already created)
CREATE DATABASE IF NOT EXISTS Employee;

-- 2. Use the database
USE Employee;

-- 3. Create the table Emp
CREATE TABLE IF NOT EXISTS Emp (
    Emp_No INT PRIMARY KEY,
    Emp_Name VARCHAR(100),
    BasicSalary DOUBLE
);


