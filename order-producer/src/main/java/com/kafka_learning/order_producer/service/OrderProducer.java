package com.kafka_learning.order_producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(String message) {
        kafkaTemplate.send("order-created", message).whenComplete((result, ex) -> {

            // if (ex == null) {
            // System.out.println("Message sent successfully");
            // } else {
            // System.out.println("Failed: " + ex.getMessage());
            // }
            if (ex == null) {

                System.out.println(
                        result.getRecordMetadata().topic());

                System.out.println(
                        result.getRecordMetadata().partition());

                System.out.println(
                        result.getRecordMetadata().offset());

            }
        });

        ;
    }
}
