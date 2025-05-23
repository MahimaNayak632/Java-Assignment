-- 1. Create the database (if not already created)
CREATE DATABASE IF NOT EXISTS Employee;

-- 2. Use the database
USE Employee;

-- 3. Create the table Emp
CREATE TABLE IF NOT EXISTS Emp (
    Emp_No INT PRIMARY KEY,
    Emp_Name VARCHAR(100),
    Basicsalary DOUBLE
);

-- 4.Inserting the valuse
INSERT INTO Emp VALUES
(101, 'Ramesh', 25000),
(102, 'Ravi', 20000),
(103, 'Suresh', 15000),
(104, 'Sneha', 18000);

