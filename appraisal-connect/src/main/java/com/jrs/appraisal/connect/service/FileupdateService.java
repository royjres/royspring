package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.dto.OrderDto;
import com.jrs.appraisal.connect.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface FileupdateService {

    public void updateAppraiser(Order order);
}
