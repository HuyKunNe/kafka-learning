package com.kafka_learning.inventory_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka_learning.inventory_service.common_event.OrderCreatedEvent;

@Component
public class DeadLetterConsumer {

    @KafkaListener(
            topics = "order-created-dlt",
            groupId = "dlt-group"
    )
    public void consume(OrderCreatedEvent event) {

        System.out.println("========== DLT ==========");
        System.out.println(event);
        System.out.println("=========================");

    }

}