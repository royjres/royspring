package com.jrs.appraisalconnect.service;

import java.util.List;

import com.jrs.appraisalconnect.model.OrderFiles;

public interface OrderFilesService {
	OrderFiles saveOrderFiles(OrderFiles orderFiles);
	
	List<OrderFiles> getOrderFiles(String myOrderId);
	
	OrderFiles getFileInfo(String myFileId);
}
