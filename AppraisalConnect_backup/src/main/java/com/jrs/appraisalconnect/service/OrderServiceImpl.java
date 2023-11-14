package com.jrs.appraisalconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrs.appraisalconnect.model.CreateOrder;
import com.jrs.appraisalconnect.model.Order;
import com.jrs.appraisalconnect.repository.OrderRepository;
import com.jrs.appraisalconnect.utils.Utils;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private Utils myutils;
	
	@Override
	public List<Order> getOrders() {
		
		return orderRepository.findAll();
		
	}

	@Override
	public Order saveOrder(Order myorder) {
		
		//String mytimestamp = myutils.get_reverse_timestamp();
		//myorder.setOrd_id(mytimestamp);
		
		return orderRepository.save(myorder);		
	}

	@Override
	public List<Order> getUserOrders(String ordUsrId) {
		
		return orderRepository.findByOrdUsrId(ordUsrId);
	}

	@Override
	public Order getOrderDetail(String orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findByOrdId(orderId);
	}

	@Override
	public Order updateOrder(Order myOrderDetail) {

		return orderRepository.save(myOrderDetail);
	}


	

}
