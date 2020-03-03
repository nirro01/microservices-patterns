package com.nirro01.order.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private String productName;
    private Double price;
}
