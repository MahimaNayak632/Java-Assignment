CREATE DATABASE IF NOT EXISTS test;

USE test;

CREATE TABLE IF NOT EXISTS coffee (
    id INT PRIMARY KEY,
    coffee_name VARCHAR(100),
    price DOUBLE
);

-- Insert sample data
INSERT INTO coffee VALUES
(1, 'Dalgona', 130.0),
(2, 'Latte', 120.0),
(3, 'Drip Coffee', 110.0),
(4, 'Espresso', 100.0);

