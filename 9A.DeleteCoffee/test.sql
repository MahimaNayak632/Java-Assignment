CREATE DATABASE IF NOT EXISTS test;

USE test;

CREATE TABLE IF NOT EXISTS coffee (
    id INT PRIMARY KEY,
    coffee_name VARCHAR(100),
    price DOUBLE
);

-- Insert sample data (optional)
INSERT INTO coffee VALUES (1, 'Latte', 120.0), (2, 'Espresso', 100.0), (3, 'Cappuccino', 150.0);

