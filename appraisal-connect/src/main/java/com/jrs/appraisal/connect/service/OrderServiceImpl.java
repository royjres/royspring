package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.dto.OrderDto;
import com.jrs.appraisal.connect.model.Borrower;
import com.jrs.appraisal.connect.model.Contact;
import com.jrs.appraisal.connect.model.Order;
import com.jrs.appraisal.connect.model.Vlog;
import com.jrs.appraisal.connect.repository.OrderRepository;
import com.jrs.appraisal.connect.repository.VlogRepository;
import com.jrs.appraisal.connect.util.myutils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    VlogRepository vlogRepository;

    @Autowired
    myutils _utils;

    @Override
    public void createServiceOrder(OrderDto orderDto) {
        log.info("Saving order....");
        try {
            Order order = orderDto.getOrder();
            if(!order.getNewfile_contact().isEmpty()) {
                order.getNewfile_contact().forEach(contact -> {
                    contact.setOrder(order);
                });
            }
            if (!order.getNewfile_borrower().isEmpty()) {
                order.getNewfile_borrower().forEach(borrower -> {
                    borrower.setOrder(order);
                });
            }
            if(!order.getNewfile_fileupload().isEmpty()){
                order.getNewfile_fileupload().forEach(orderFile -> {
                    orderFile.setUploadtime(new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()));
                    orderFile.setOrder(order);
                });
            }
            if(!order.getNewfile_reports().isEmpty()){
                order.getNewfile_reports().forEach(orderReports -> {
                    orderReports.setOrder(order);
                });
            }

            String myFileNum = _utils.get_FileNum(order.getNewfile_organization());

            order.setNewfile_filenum(myFileNum);
            order.setNewfile_status("0");

            Order savedOrderEntity = orderRepository.save(order);

            createOrderVlog(savedOrderEntity);

            }catch (Exception e){
                e.printStackTrace();
        }
    }


    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(String id) {
        Order order = null;
        try {
             order = orderRepository.findById(id).get();
        } catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    public void createOrderVlog(Order order) {

        log.info("Saving vlog....");
        Vlog myvlog = new Vlog();
        String mystr = order.getOrdId();

        myvlog.setVlogFileId(mystr);

        StringBuilder mystr_rev = new StringBuilder(mystr);
        mystr = mystr_rev.reverse().toString();

        String myDate = mystr.substring(0,8);
        String myTime = mystr.substring(8,14);
        myvlog.setVlogDescription("FILE OPENED");
        myvlog.setVlogUser("Roy Noronha");
        myvlog.setVlogDate(myDate);
        myvlog.setVlogTime(myTime);
        myvlog.setVlogUserLevel("2");
        log.info(myvlog.toString());

        vlogRepository.save(myvlog);

    }
}
