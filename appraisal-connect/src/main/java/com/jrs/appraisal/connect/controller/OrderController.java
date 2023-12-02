package com.jrs.appraisal.connect.controller;

import com.jrs.appraisal.connect.dto.OrderDto;
import com.jrs.appraisal.connect.model.Fileexception;
import com.jrs.appraisal.connect.model.Order;
//import com.jrs.appraisal.connect.model.Vlog;
import com.jrs.appraisal.connect.service.FileexceptionService;
import com.jrs.appraisal.connect.service.OrderService;
//import com.jrs.appraisal.connect.service.VlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {


    private final OrderService orderService;

    private final FileexceptionService fileexceptionService;

    public OrderController(OrderService orderService, FileexceptionService fileexceptionService) {
        this.orderService = orderService;
        this.fileexceptionService = fileexceptionService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
        log.info("Create order {}", orderDto);
        orderService.createServiceOrder(orderDto);


        return new ResponseEntity<>("Order saved successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/retrieve")
    public List<Order> getOrders(){
        log.info("retrieve all orders");
        return orderService.getOrders();
    }

    @GetMapping("/byId/{id}")
    public Order getOrder(@PathVariable String id) {
        log.info("get order by id ");
        return orderService.getOrderById(id);
    }

    @GetMapping("/exception")
    public List<Fileexception> getExceptions() {
        log.info("get exceptions");
        return fileexceptionService.getExceptions();
    }


}
