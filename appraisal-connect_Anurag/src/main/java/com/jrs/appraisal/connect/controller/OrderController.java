package com.jrs.appraisal.connect.controller;

import com.jrs.appraisal.connect.dto.OrderDto;
import com.jrs.appraisal.connect.model.Order;
import com.jrs.appraisal.connect.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
        log.info("Create order {}", orderDto);
        return new ResponseEntity<>(orderService.createServiceOrder(orderDto), HttpStatus.CREATED);
    }

    @GetMapping("/retrieve")
    public List<Order> getOrders(){
        log.info("retrieve all orders");
        return orderService.getOrders();
    }

    @GetMapping("/byId")
    public Order getOrder(){
        log.info("get order by id ");
        return new Order();
    }
}
