package com.jrs.appraisalconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrs.appraisalconnect.model.Vlog;
import com.jrs.appraisalconnect.repository.VlogRepository;

@Service
public class VlogServiceImpl implements VlogService {

	@Autowired
	VlogRepository myVlogRepository;
	
	@Override
	public Vlog saveVlog(Vlog myVlog) {
		// 
		return myVlogRepository.save(myVlog);
	}

}
