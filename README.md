# programs

**com.example**

This package contains Java programs for
- Balanced Brackets
- Circular Queue
- Queue
- Singleton Design Pattern
- Stack

**com.kafka**

- Install the latest Apache Zookeeper and Apache Kafka

- Start Zookeeper    
    - `bin\zkServer.cmd`
    
- Start Kafka
    - `bin\windows\kafka-server-start.bat config\server.properties`
    
- List Topics
    - `bin\windows\kafka-topics.bat --zookeeper localhost:2181 --list`
    
- Create Topic
    -  `bin\windows\kafka-topics.bat --zookeeper localhost:2181 --create --replication-factor 1 --partitions 1 --topic kafka-topic`
    
- Start Consumer
    - `bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafka-topic --from-beginning`
    
- Start Producer
    - `bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic kafka-topic`
    
- Run Simple Consumer and Simple Producer Test Cases

**com.mongodb**

- Install the latest Mongo DB

- Start Mongo DB
    - `bin\mongod.exe --port 27017 --dbpath data`
    
- Start Mongo Shell
    - `bin\mongo.exe --port 27017`
    
- Create User
    - `db.createUser(
        {
          user: "mydbUser",
          pwd: "mydbPassword",
          roles: ["readWrite", "dbAdmin", "dbOwner"]
        }
      )`
      
- Shutdown Mongo DB from Mongo Shell
    - `db.adminCommand({shutdown: 1})`
    
- Exit Mongo Shell
    
- Start Mongo DB with Auth Option
    - `bin\mongod.exe --auth --port 27017 --dbpath data`
    
- Start Mongo Shell with Auth
    - `bin\mongo.exe --port 27017 --authenticationDatabase "mydb" -u "mydbUser" -p mydbPassword`
    - OR
    - `bin\mongo.exe --port 27017`
    - `use mydb`
    - `db.auth("mydbUser", "mydbPassword")`
    
- Create Database
    - `use mydb`
    
- Create Collection
    - `db.createCollection("employee")`
    
- Get List of Databases
    - `show dbs`
    - `db.getMongo().getDBNames()`
    - `db.adminCommand('listDatabases')`
    
- Get List of Collections
    - `show collections`
    - `show tables`
    - `db.getCollectionNames()`
    
- Insert Document
    - `db.employee.insert({"name":"Scott Tiger", "id":1}`)
    
- Insert Document without creating Collection
    - `db.student.insert({"name":"Scott Tiger", "id":1})`
    
- Insert Multiple Documents
    - `db.employee.insert([{"name":"Scott Tigress", "id":2} , {"name":"Scott Tiger Cub", "id":3}])`

- Get All Documents
    - `db.employee.find()`
    - `db.employee.find({})`
    
- Get Document Pretty Print
    - `db.employee.find().pretty()`
    
- Get Document with Query
    - `db.employee.find({"id":2}).pretty()`
    - `db.employee.find({"id":{$lt:2}}).pretty()`
    - `db.employee.find({"id":{$lte:2}}).pretty()`
    - `db.employee.find({"id":{$gt:2}}).pretty()`
    - `db.employee.find({"id":{$gte:2}}).pretty()`
    - `db.employee.find({"id":{$ne:2}}).pretty()`
    - `db.employee.find(
         {
            $and: [
               {"id":2}, {"name":"Scott Tigress"}
            ]
         }
      ).pretty()`
    - `db.employee.find(
         {
            $or: [
               {"id":2}, {"id":3}
            ]
         }
      ).pretty()`
    - `db.employee.find({"id": {$gt:2}, $or: [{"id":2}, {"id":3}]}).pretty()`
    
- Get Documents with Specific Fields
    - `db.employee.find({}, {"_id":0,"name":1})`
    
- Get Documents with Limit
    - `db.employee.find().limit(2)`
    
- Get Documents with Skipped Documents
    - `db.employee.find().skip(1)`
    
- Get Documents Sorted
    - `db.employee.find().sort({"id":1})`
    - `db.employee.find().sort({"id":-1})`
    
- Create Index
    - `db.employee.ensureIndex({"id":1})`
    
- Get Indexes
    - `db.employee.getIndexes()`
    
- Drop Index
    - `db.employee.dropIndex("id_1")`
    
- Update Document
    - `db.employee.update({"id":3},{$set:{'id':4}})`
    
- Replace Document
    - `db.employee.save({"_id":ObjectId("5fc13deaca8e35f7e9ae88a4"), "name":"Scott Tiger Cub and Bulbul", "id":5})`
    
- Remove Document
    - `db.employee.remove({"id":5})`
    
- Remove First Document
    - `db.employee.remove({"id":5}, 1)`
    
- Remove All Documents
    - `db.employee.remove({})`
    
- Drop Collections
    - `db.student.drop()`
    
- Drop Database
    - `db.dropDatabase()`
    
- Run Mongo Connector Test Cases

**com.mysql**

- Install MySQL Server with MySQL Shell and MySQL Workbench
    - Configure MySQL Server

- Add below environment variables
    - MYSQL_HOME: C:\Program Files\MySQL\MySQL Server 8.0
    - PATH: %MYSQL_HOME%\bin
    
- Connect to MySQL DB 
    - `mysql -u root -ppassword -h localhost`
    - OR
    - Use MySQL Workbench
    
- Show Databases
    - `SHOW DATABASES;`
    
- Create Database
    - `CREATE DATABASE mydb;`
    
- Use Database
    - `USE mydb;`
    
- Show Tables
    - `SHOW TABLES;`
    
- Create Table
    - `CREATE TABLE employee (
        id INT NOT NULL,
        name VARCHAR(45) NOT NULL,
        PRIMARY KEY (id));`
        
- Describe Table
    - `DESCRIBE employee;`
    
- Insert Row
    - `INSERT INTO employee(id, name) VALUES (1, "Scott Tiger");`
    - `INSERT INTO employee(id, name) VALUES (2, "Scott Tigress");`
    - `INSERT INTO employee(id, name) VALUES (3, "Scott Tiger Cub");`

- Select All Columns and All Rows
    -  `SELECT * FROM employee;`
    
- Select with Specific Columns 
    - `SELECT name FROM employee;`

- Select Rows with Sorting
    - `SELECT * FROM employee ORDER BY id DESC;`
    - `SELECT * FROM employee ORDER BY id ASC;`
    
- Select Row with Specific Condition
    - `SELECT * FROM employee WHERE id=2;`
    - `SELECT * FROM employee WHERE id>2;`
    - `SELECT * FROM employee WHERE id>=2;`
    - `SELECT * FROM employee WHERE id<2;`
    - `SELECT * FROM employee WHERE id<=2;`
    - `SELECT * FROM employee WHERE id!=2;`
    - `SELECT * FROM employee WHERE id<>2;`
    - `SELECT * FROM employee WHERE id IN (1, 2);`
    - `SELECT * FROM employee WHERE id NOT IN (1, 2);`
    - `SELECT * FROM employee WHERE id BETWEEN 1 AND 2;`
    - `SELECT * FROM employee WHERE id NOT BETWEEN 1 AND 2;`
    - `SELECT * FROM employee WHERE name="Scott Tigress";`
    - `SELECT * FROM employee WHERE name!="Scott Tigress";`
    - `SELECT * FROM employee WHERE name LIKE "Scott Tiger%";`
    - `SELECT * FROM employee WHERE name NOT LIKE "Scott Tigress%";`
   
- Create Table from Another Table
    - `CREATE TABLE student AS SELECT * FROM employee;`
    
- Update Column in Specific Row
    - `UPDATE employee SET id=4 WHERE name="Scott Tiger Cub";`

- Inner Join
    - `SELECT * FROM employee e
      INNER JOIN student s ON s.id=e.id;`

- Natural Join
    - `SELECT * FROM employee e
      NATURAL JOIN student s;`

- Left Join
    - `SELECT * FROM employee e
      LEFT JOIN student s ON s.id=e.id;`

- Right Join
    - `SELECT * FROM employee e
      RIGHT JOIN student s ON s.id=e.id;`

- Cartesian Product
    - `SELECT * FROM employee e, student s;`

- Alter Table
    - `ALTER TABLE employee 
      ADD COLUMN age INT NULL AFTER name;`
      
- Create Index
    - `CREATE UNIQUE INDEX unique_emp_id ON employee (id);`
    
- Drop Index
    - `DROP INDEX unique_emp_id on employee;`
    
- Create Sequence
    - `ALTER TABLE employee
      CHANGE COLUMN id id INT NOT NULL AUTO_INCREMENT;`

- Insert Row with Auto Incremented id
    - `INSERT INTO employee (name) VALUES ('Scott Bulbul');`
    
- Mathematical Operations
    - `SELECT 5 + 3;`
    - `SELECT 5 - 3;`
    - `SELECT 5 * 3;`
    - `SELECT 5 / 3;`
    - `SELECT 5 DIV 3;`
    - `SELECT 5 % 3;`
    - `SELECT 5 MOD 3;`
    - `SELECT PI();`
    - `SELECT POW(2, 2);`
    - `SELECT SQRT(4);`
    - `SELECT RAND();`
    - `SELECT ABS(-10);`
    - `SELECT ROUND(4.51, 1);`
    - `SELECT ROUND(4.49, 1);`
    - `SELECT ROUND(-4.51, 1);`
    - `SELECT ROUND(-4.49, 1);`
    - `SELECT ROUND(4.51);`
    - `SELECT ROUND(4.49);`
    - `SELECT ROUND(-4.51);`
    - `SELECT ROUND(-4.49);`
    - `SELECT CEIL(4.51);`
    - `SELECT CEILING(4.49);`
    - `SELECT CEIL(-4.51);`
    - `SELECT CEILING(-4.49);`
    - `SELECT FLOOR(4.51);`
    - `SELECT FLOOR(4.49);`
    - `SELECT FLOOR(-4.51);`
    - `SELECT FLOOR(-4.49);`
    
- Date Operations
    - `SELECT now();`
    - `SELECT curdate();`
    - `SELECT now() + INTERVAL 1 DAY;`
    - `SELECT curdate() - INTERVAL 4 DAY;`
      
- Update Column in All Rows
    - `UPDATE employee SET name="Scott Tiger Cubs and Bulbuls";`
    
- Delete Specific Row
    - `DELETE FROM employee WHERE id=4;`
    
- Delete All Rows
    - `DELETE FROM employee;`

- Truncate Table
    - `TRUNCATE TABLE employee;`
    
- Drop Table
    - `DROP TABLE employee;`

- Drop Database
    - `DROP DATABASE mydb;`
    
- Run MySQL Connector Test Cases

**com.postgresql**

- Download PostgreSQL zip

- cd postgresql

- Initialize Database
  - `bin\initdb -D mydb -U mydbUser -W -E UTF8 -A scram-sha-256`
  
- Start Server
  - `bin\pg_ctl -D mydb start -l logfile`
  
- Create Database
  - `bin\createdb -U mydbUser -W mydb`

- Login Database
  - `bin\psql -U mydbUser -d mydb`
  
- Create Database from psql console
  - `CREATE DATABASE test_db;`
  
- Drop Database
  - `DROP DATABASE TEST_DB;`
  - `dropdb -U mydbUser test_db`
  
- Stop Server
  - `bin\pg_ctl -D mydb stop`

Express JS:

- Install Node Modules
  - `npm install`
  
- Run Independent Express JS Server
  - `node src\main\webapp\express\app.js`
  
- Check Express JS Server with below URLs
  - `GET http://localhost:3000`
  - `POST http://localhost:3000`
  - `GET http://localhost:3000/hello`
  - `POST http://localhost:3000/hello`
  - `GET http://localhost:3000/hello/myname`
  - `GET http://localhost:3000/routes`
  - `POST http://localhost:3000/routes`
  
- Using Express Generator
  - `node_modules\.bin\express express-app`
  
- cd express-app

- Install Node Modules
  - `npm install`
  
- Start Express JS App
  - `set DEBUG=expressapp:* & npm start`
