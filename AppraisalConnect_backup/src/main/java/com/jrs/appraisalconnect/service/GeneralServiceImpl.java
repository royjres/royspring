package com.jrs.appraisalconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrs.appraisalconnect.model.OrderDetail;

@Service
public class GeneralServiceImpl implements GeneralService {

	@Autowired
	OrderService orderService;

	@Autowired
	BorrowerService borrowerService;

	@Autowired
	ContactService contactService;

	@Autowired
	OrderReportsService orderReportsService;;
	
	
	@Override
	public OrderDetail getOrderById(String orderDetailId) {
		
		OrderDetail myOrderDetail = new OrderDetail();
		
		myOrderDetail.setOrder(orderService.getOrderDetail(orderDetailId));
		myOrderDetail.setBorrowers(borrowerService.getBorrowerById(orderDetailId));
		myOrderDetail.setContacts(contactService.getContactById(orderDetailId));
		myOrderDetail.setReports(orderReportsService.getReportsById(orderDetailId));
		
		
		return myOrderDetail;
	}

}
