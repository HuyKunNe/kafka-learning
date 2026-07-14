package com.kafka_learning.order_producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka_learning.order_producer.common_event.OrderCreatedEvent;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderProducer(
            KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void createOrder(OrderCreatedEvent event) {

        kafkaTemplate.send(
                "order-created",
                event.getCustomerId().toString(),
                event);

    }
}