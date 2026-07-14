package com.kafka_learning.inventory_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka_learning.inventory_service.common_event.OrderCreatedEvent;

@Component
public class InventoryConsumer {

    @KafkaListener(topics = "order-created", groupId = "inventory-group")
    public void consume(OrderCreatedEvent event) {
        System.out.println("======================");
        System.out.println("Inventory Service Received Event");
        System.out.println("Order ID: " + event.getOrderId());
        System.out.println("Customer: " + event.getCustomerName());
        System.out.println("Amount: " + event.getTotalAmount());
        System.out.println("======================");
    }
}