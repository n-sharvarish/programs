package com.kafka;

import com.example.TestUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

public class SimpleConsumerTest {

    @BeforeClass
    public void setUp() {
        TestUtils.setUpMessage(this.getClass());
    }

    @AfterClass
    public void tearDown() {
        TestUtils.tearDownMessage(this.getClass());
    }

    //@Test(timeOut = 10000, expectedExceptions = {Exception.class})
    public void testKafkaConsumer() {

        Properties properties = new Properties();
        properties.put("topic.name", "kafka-topic");
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "kafka-consumer");

        properties.put("auto.offset.reset", "latest");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("session.timeout.ms", "30000");

        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        SimpleConsumer consumer = new SimpleConsumer(properties);
        consumer.consume();
    }
}
