-- 1. Create the database (if not already created)

CREATE DATABASE IF NOT EXISTS test;

-- 2. Use the database
   USE test;

-- 3. Create the table Emp

CREATE TABLE IF NOT EXISTS coffee (
    id INT PRIMARY KEY,
    coffee_name VARCHAR(100),
    price DOUBLE
);

