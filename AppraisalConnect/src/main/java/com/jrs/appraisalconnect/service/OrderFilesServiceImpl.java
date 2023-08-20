package com.jrs.appraisalconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrs.appraisalconnect.model.OrderFiles;
import com.jrs.appraisalconnect.repository.OrderFilesRepository;

@Service
public class OrderFilesServiceImpl implements OrderFilesService {

	@Autowired
	OrderFilesRepository orderFilesRepository;
	
	@Override
	public OrderFiles saveOrderFiles(OrderFiles orderFile) {
		// TODO Auto-generated method stub
		return orderFilesRepository.save(orderFile);
	}

	@Override
	public List<OrderFiles> getOrderFiles(String myOrderId) {
		
		return orderFilesRepository.findByFilOrdId(myOrderId);
	}

	@Override
	public OrderFiles getFileInfo(String myFileId) {
		// TODO Auto-generated method stub
		return orderFilesRepository.findByFilId(myFileId);
	}

}
