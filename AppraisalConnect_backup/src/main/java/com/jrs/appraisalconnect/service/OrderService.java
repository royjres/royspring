package com.jrs.appraisalconnect.service;

import java.util.List;

import com.jrs.appraisalconnect.model.CreateOrder;
import com.jrs.appraisalconnect.model.Order;

public interface OrderService {
	List<Order> getOrders();
	
	List<Order> getUserOrders(String ordUsrId);
	
	Order saveOrder(Order myorder);
	
	Order getOrderDetail(String orderId);
	
	Order updateOrder(Order myorderDetail);

	
}
