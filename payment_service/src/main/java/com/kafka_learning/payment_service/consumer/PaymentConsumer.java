package com.kafka_learning.payment_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka_learning.payment_service.common_event.OrderCreatedEvent;

@Component
public class PaymentConsumer {


    @KafkaListener(
            topics = "order-created",
            groupId = "payment-group"
    )
    public void consume(OrderCreatedEvent event){

        System.out.println("======================");
        System.out.println("Payment Service");
        System.out.println(event);
        System.out.println("======================");

    }

}