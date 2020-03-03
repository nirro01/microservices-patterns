package com.nirro01.order.service;

import com.nirro01.order.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private KafkaTemplate<String, Order> kafkaTemplate;
    private String orderCreatedTopic;

    public OrderService(KafkaTemplate<String, Order> kafkaTemplate, @Value("${kafka.topic.order-created}") String orderCreatedTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderCreatedTopic = orderCreatedTopic;
    }

    public void send(Order order) {
        kafkaTemplate.send(orderCreatedTopic, order);
    }
}
