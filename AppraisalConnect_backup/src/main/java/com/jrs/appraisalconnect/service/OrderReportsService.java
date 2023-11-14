package com.jrs.appraisalconnect.service;

import java.util.List;

import com.jrs.appraisalconnect.model.OrderReports;

public interface OrderReportsService {
	OrderReports saveOrderReports(OrderReports myOrderReports);
	
	List<OrderReports> getReportsById(String myOrderId);
	
	void deleteReportsById(OrderReports myOrderReports);
}
