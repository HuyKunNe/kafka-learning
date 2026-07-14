package com.kafka_learning.inventory_service.common_event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class OrderCreatedEvent {
    private Long orderId;
    private Long customerId;
    private String customerName;
    private Double totalAmount;
}