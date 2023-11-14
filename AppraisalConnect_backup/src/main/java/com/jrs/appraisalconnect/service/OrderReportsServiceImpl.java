package com.jrs.appraisalconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrs.appraisalconnect.model.OrderReports;
import com.jrs.appraisalconnect.repository.OrderReportsRepository;

@Service
public class OrderReportsServiceImpl implements OrderReportsService {

	@Autowired
	private OrderReportsRepository orderReportsRepository;
	
	@Override
	public OrderReports saveOrderReports(OrderReports myOrderReports) {
		// 
		return orderReportsRepository.save(myOrderReports);
	}

	@Override
	public List<OrderReports> getReportsById(String myOrderId) {
		
		return orderReportsRepository.findByRptOrdId(myOrderId);
	}

	@Override
	public void deleteReportsById(OrderReports myOrderReports) {
		// TODO Auto-generated method stub
		orderReportsRepository.delete(myOrderReports);
	}

}
