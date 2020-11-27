package com.kafka;

import com.example.TestUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

public class SimpleProducerTest {

    @BeforeClass
    public void setUp() {
        TestUtils.setUpMessage(this.getClass());
    }

    @AfterClass
    public void tearDown() {
        TestUtils.tearDownMessage(this.getClass());
    }

    //@Test(timeOut = 10000)
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
