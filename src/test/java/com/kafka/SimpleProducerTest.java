package com.kafka;

import com.example.BaseTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class SimpleProducerTest extends BaseTest {

    //@Test
    public void testKafkaProducer() {

        Properties properties = new Properties();
        properties.put("topic.name", "kafka-topic");
        properties.put("bootstrap.servers", "localhost:9092");
        //properties.put("client.id", "kafka-producer");

        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);

        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        SimpleProducer producer = new SimpleProducer(properties);
        producer.produce();
    }
}
