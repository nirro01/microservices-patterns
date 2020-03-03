package com.nirro01.order.model;

import com.nirro01.order.dto.OrderDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@NoArgsConstructor
@Document
public class Order {
    @Id
    private Long id;
    private String productName;
    private Double price;
    private Instant createdAt;

    public Order(OrderDTO orderDTO) {
        this.id = orderDTO.getId();
        this.productName = orderDTO.getProductName();
        this.price = orderDTO.getPrice();
        this.createdAt = Instant.now();
    }
}
