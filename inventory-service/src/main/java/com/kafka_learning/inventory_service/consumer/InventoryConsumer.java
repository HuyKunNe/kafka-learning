package com.kafka_learning.inventory_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.kafka_learning.inventory_service.common_event.OrderCreatedEvent;

@Component
public class InventoryConsumer {

    @KafkaListener(topics = "order-created", groupId = "inventory-group")
    public void consume(OrderCreatedEvent event,
            Acknowledgment acknowledgment) {

        System.out.println("Receive: " + event);

        // Business logic
        if (event.getOrderId() == 999) {
            throw new RuntimeException("DB Error");
        }

        acknowledgment.acknowledge();

        System.out.println("Offset committed");
    }
}