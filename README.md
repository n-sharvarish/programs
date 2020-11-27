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