package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.dto.OrderDto;
import com.jrs.appraisal.connect.model.Order;
import com.jrs.appraisal.connect.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Override
    public Order createServiceOrder(OrderDto orderDto) {
        log.info("Saving order....");
        Order order = orderDto.getOrder();
        order.setBorrowers(Arrays.stream(orderDto.getBorrowers()).toList());
        order.setContacts(Arrays.stream(orderDto.getContacts()).toList());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
