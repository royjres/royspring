package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.dto.OrderDto;
import com.jrs.appraisal.connect.model.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {

    public Order createServiceOrder(OrderDto orderDto);

    public List<Order> getOrders();
}
