# programs

com.example

com.kafka

- Install the latest Apache Zookeeper and Apache Kafka

- Start Zookeeper    
    - bin\zkServer.cmd
    
- Start Kafka
    - bin\windows\kafka-server-start.bat config\server.properties
    
- List Topics
    - bin\windows\kafka-topics.bat --zookeeper localhost:2181 --list
    
- Create Topic
    -  bin\windows\kafka-topics.bat --zookeeper localhost:2181 --create --replication-factor 1 --partitions 1 --topic kafka-topic
    
- Start Consumer
    - bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafka-topic --from-beginning
    
- Start Producer
    - bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic kafka-topic
    
- Run Simple Consumer and Simple Producer Test Cases

com.mongodb

- Install the latest Mongo DB

- Start Mongo DB
    - bin\mongod.exe --port 27017 --dbpath data
    
- Start Mongo Shell
    - bin\mongo.exe --port 27017
    
- Create User
    - db.createUser(
        {
          user: "mydbUser",
          pwd: "mydbPassword",
          roles: ["readWrite", "dbAdmin", "dbOwner"]
        }
      )
      
- Shutdown Mongo DB from Mongo Shell
    - db.adminCommand({shutdown: 1})
    
- Exit Mongo Shell
    
- Start Mongo DB with Auth Option
    - bin\mongod.exe --auth --port 27017 --dbpath data
    
- Start Mongo Shell with Auth
    - bin\mongo.exe --port 27017 --authenticationDatabase "mydb" -u "mydbUser" -p mydbPassword
    - OR
    - bin\mongo.exe --port 27017
    - use mydb
    - db.auth("mydbUser", "mydbPassword")
    
- Create Database
    - use mydb
    
- Create Collection
    - db.createCollection("employee")
    
- Get List of Databases
    - show dbs
    - db.getMongo().getDBNames()
    - db.adminCommand('listDatabases')
    
- Get List of Collections
    - show collections
    - show tables
    - db.getCollectionNames()
    
- Insert Document
    - db.employee.insert({"name":"Scott Tiger", "id":1})
    
- Insert Document without creating Collection
    - db.student.insert({"name":"Scott Tiger", "id":1})
    
- Insert Multiple Documents
    - db.employee.insert([{"name":"Scott Tigress", "id":2} , {"name":"Scott Tiger Cub", "id":3}])

- Get All Documents
    - db.employee.find()
    - db.employee.find({})
    
- Get Document Pretty Print
    - db.employee.find().pretty()
    
- Get Document with Query
    - db.employee.find({"id":2}).pretty()
    - db.employee.find({"id":{$lt:2}}).pretty()
    - db.employee.find({"id":{$lte:2}}).pretty()
    - db.employee.find({"id":{$gt:2}}).pretty()
    - db.employee.find({"id":{$gte:2}}).pretty()
    - db.employee.find({"id":{$ne:2}}).pretty()
    - db.employee.find(
         {
            $and: [
               {"id":2}, {"name":"Scott Tigress"}
            ]
         }
      ).pretty()
    - db.employee.find(
         {
            $or: [
               {"id":2}, {"id":3}
            ]
         }
      ).pretty()
    - db.employee.find({"id": {$gt:2}, $or: [{"id":2}, {"id":3}]}).pretty()
    
- Get Documents with Specific Fields
    - db.employee.find({}, {"_id":0,"name":1})
    
- Get Documents with Limit
    - db.employee.find().limit(2)
    
- Get Documents with Skipped Documents
    - db.employee.find().skip(1)
    
- Get Documents Sorted
    - db.employee.find().sort({"id":1})
    - db.employee.find().sort({"id":-1})
    
- Create Index
    - db.employee.ensureIndex({"id":1})
    
- Get Indexes
    - db.employee.getIndexes()
    
- Drop Index
    - db.employee.dropIndex("id_1")
    
- Update Document
    - db.employee.update({"id":3},{$set:{'id':4}})
    
- Replace Document
    - db.employee.save({"_id":ObjectId("5fc13deaca8e35f7e9ae88a4"), "name":"Scott Tiger Cub and Bulbul", "id":5})
    
- Remove Document
    - db.employee.remove({"id":5})
    
- Remove First Document
    - db.employee.remove({"id":5}, 1)
    
- Remove All Documents
    - db.employee.remove({})
    
- Drop Collections
    - db.student.drop()
    
- Drop Database
    - db.dropDatabase()
    
- Run Mongo Connector Test Cases

