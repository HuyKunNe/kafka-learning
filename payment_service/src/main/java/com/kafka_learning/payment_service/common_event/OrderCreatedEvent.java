package com.kafka_learning.payment_service.common_event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCreatedEvent {

    private Long orderId;

    private Long customerId;

    private String customerName;

    private Double totalAmount;

}
