package com.kafka_learning.inventory_service.consumer;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka_learning.inventory_service.common_event.OrderCreatedEvent;

@Component
public class BatchInventoryConsumer {

    @KafkaListener(topics = "order-created", groupId = "inventory-batch-group", containerFactory = "batchFactory")
    public void consume(List<OrderCreatedEvent> events) {

        System.out.println("======================");
        System.out.println("Batch size : " + events.size());

        events.forEach(System.out::println);

        System.out.println("======================");
    }
}