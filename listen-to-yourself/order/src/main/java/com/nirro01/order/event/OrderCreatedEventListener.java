package com.nirro01.order.event;

import com.nirro01.order.model.Order;
import com.nirro01.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class OrderCreatedEventListener {
    private OrderRepository orderRepository;

    @KafkaListener(topics = "${kafka.topic.order-created}", groupId = "${group.id}")
    public void listen(Order order) {
        log.info("Received order: " + order);
        orderRepository.save(order);
    }
}
