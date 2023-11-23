package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.model.Order;
import com.jrs.appraisal.connect.model.Vlog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VlogService {

    public void createVlog(Vlog vlog);

    public List<Vlog> getVlogsById(String id);

}
