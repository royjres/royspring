package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.model.Order;
import com.jrs.appraisal.connect.model.Vlog;
import com.jrs.appraisal.connect.repository.OrderRepository;
import com.jrs.appraisal.connect.repository.VlogRepository;
import com.jrs.appraisal.connect.util.myutils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
public class FileupdateServiceImpl implements FileupdateService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    VlogRepository vlogRepository;


    @Override
    public void updateAppraiser(Order order) {

        try {
            order = orderRepository.save(order);

            Vlog myvlog = new Vlog();
            myvlog.setVlogOrdId(order.getOrdId());
            //String myDate = myOrderId.substring(0,9).replace(".","-");
            myvlog.setVlogDescription( "Appraiser Assigned: " + order.getNewfile_appraiser());
            myvlog.setVlogUser("Roy Noronha");
            myvlog.setVlogDate("myDate");
            myvlog.setVlogTime("myTime");
            myvlog.setVlogUserLevel("2");
            vlogRepository.save(myvlog);

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
