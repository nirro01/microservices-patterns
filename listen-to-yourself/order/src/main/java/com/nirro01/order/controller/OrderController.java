package com.nirro01.order.controller;

import com.nirro01.order.model.Order;
import com.nirro01.order.dto.OrderDTO;
import com.nirro01.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping(path= "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO orderDTO)
    {
        orderService.send(new Order(orderDTO));

        return ResponseEntity.accepted().build();
    }
}
