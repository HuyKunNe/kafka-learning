package com.kafka_learning.order_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka_learning.order_producer.common_event.OrderCreatedEvent;
import com.kafka_learning.order_producer.service.OrderProducer;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String createOrder(@RequestBody OrderCreatedEvent event) {

        producer.createOrder(event);

        return "Message Sent!";
    }
}