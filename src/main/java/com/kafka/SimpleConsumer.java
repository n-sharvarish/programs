package com.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.stream.StreamSupport;

public class SimpleConsumer {

    private final Properties properties;

    public SimpleConsumer(Properties properties) {
        this.properties = properties;
    }

    public void consume() {

        try (Consumer<String, String> consumer = new KafkaConsumer<>(this.properties)) {

            String topicName = this.properties.getProperty("topic.name");
            consumer.subscribe(Collections.singletonList(topicName));
            System.out.println("Subscribed to topic " + topicName);

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                if (records.isEmpty()) continue;
                StreamSupport.stream(records.spliterator(), false).forEach(System.out::println);
            }
        }
    }
}
