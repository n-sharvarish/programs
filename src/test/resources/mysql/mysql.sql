# This comment continues to the end of line

-- This comment continues to the end of line

/* This is an in-line comment */

/*
This is a
multiple-line comment
*/

SHOW DATABASES;

CREATE DATABASE mydb;

USE mydb;

SHOW TABLES;

CREATE TABLE employee (
        id INT NOT NULL,
        name VARCHAR(45) NOT NULL,
        PRIMARY KEY (id));
        
DESCRIBE employee;

INSERT INTO employee(id, name) VALUES (1, "Scott Tiger");
INSERT INTO employee(id, name) VALUES (2, "Scott Tigress");
INSERT INTO employee(id, name) VALUES (3, "Scott Tiger Cub");

SELECT * FROM employee;

SELECT name FROM employee;

SELECT * FROM employee ORDER BY id DESC;
SELECT * FROM employee ORDER BY id ASC;

SELECT * FROM employee WHERE id=2;
SELECT * FROM employee WHERE id>2;
SELECT * FROM employee WHERE id>=2;
SELECT * FROM employee WHERE id<2;
SELECT * FROM employee WHERE id<=2;
SELECT * FROM employee WHERE id!=2;
SELECT * FROM employee WHERE id<>2;

SELECT * FROM employee WHERE id IN (1, 2);
SELECT * FROM employee WHERE id NOT IN (1, 2);
SELECT * FROM employee WHERE id BETWEEN 1 AND 2;
SELECT * FROM employee WHERE id NOT BETWEEN 1 AND 2;

SELECT * FROM employee WHERE name="Scott Tigress";
SELECT * FROM employee WHERE name!="Scott Tigress";
SELECT * FROM employee WHERE name LIKE "Scott Tiger%";
SELECT * FROM employee WHERE name NOT LIKE "Scott Tigress%";

CREATE TABLE student AS SELECT * FROM employee;

UPDATE employee SET id=4 WHERE name="Scott Tiger Cub";

SELECT * FROM employee e 
INNER JOIN student s ON s.id=e.id;

SELECT * FROM employee e
NATURAL JOIN student s;

SELECT * FROM employee e
LEFT JOIN student s ON s.id=e.id;

SELECT * FROM employee e
RIGHT JOIN student s ON s.id=e.id;

SELECT * FROM employee e, student s;

ALTER TABLE employee 
ADD COLUMN age INT NULL AFTER name;

CREATE UNIQUE INDEX unique_emp_id ON employee (id);

DROP INDEX unique_emp_id on employee;

ALTER TABLE employee
CHANGE COLUMN id id INT NOT NULL AUTO_INCREMENT;

INSERT INTO employee (name) VALUES ('Scott Bulbul');

SELECT 5 + 3;
SELECT 5 - 3;
SELECT 5 * 3;
SELECT 5 / 3;
SELECT 5 DIV 3;
SELECT 5 % 3;
SELECT 5 MOD 3;
SELECT PI();

SELECT POW(2, 2);
SELECT SQRT(4);
SELECT RAND();
SELECT ABS(-10);

SELECT ROUND(4.51, 1);
SELECT ROUND(4.49, 1);
SELECT ROUND(-4.51, 1);
SELECT ROUND(-4.49, 1);

SELECT ROUND(4.51);
SELECT ROUND(4.49);
SELECT ROUND(-4.51);
SELECT ROUND(-4.49);

SELECT CEIL(4.51);
SELECT CEILING(4.49);
SELECT CEIL(-4.51);
SELECT CEILING(-4.49);

SELECT FLOOR(4.51);
SELECT FLOOR(4.49);
SELECT FLOOR(-4.51);
SELECT FLOOR(-4.49);

SELECT now();
SELECT curdate();
SELECT now() + INTERVAL 1 DAY;
SELECT curdate() - INTERVAL 4 DAY;

UPDATE employee SET name="Scott Tiger Cubs and Bulbuls";
      
DELETE FROM employee WHERE id=4;

DELETE FROM employee;

TRUNCATE TABLE employee;

DROP TABLE employee;

DROP DATABASE mydb;