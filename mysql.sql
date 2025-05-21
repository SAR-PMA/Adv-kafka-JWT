CREATE DATABASE IF NOT EXISTS employeedb;
USE employeedb;
CREATE TABLE employee_kafka (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  age INT
);
