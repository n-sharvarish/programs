package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SimpleProducer {

    private final Properties properties;

    public SimpleProducer(Properties properties) {
        this.properties = properties;
    }

    public void produce() {

        try (Producer<String, String> producer = new KafkaProducer<String, String>(this.properties)) {

            String topicName = this.properties.getProperty("topic.name");

            for (int i = 0; i < 5; i++) {
                ProducerRecord<String, String> message = new ProducerRecord<>(topicName, "this is kafka message " + i);
                producer.send(message);
                System.out.println("message sent.");
            }
        }
    }
}
