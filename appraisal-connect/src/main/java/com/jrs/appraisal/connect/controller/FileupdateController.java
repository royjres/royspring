package com.jrs.appraisal.connect.controller;

import com.jrs.appraisal.connect.model.Fileupdate;
import com.jrs.appraisal.connect.model.Order;
import com.jrs.appraisal.connect.service.OrderService;
import com.jrs.appraisal.connect.util.myutils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jrs.appraisal.connect.service.FileupdateService;

@Slf4j
@RestController
@RequestMapping("/fileupdate")
@CrossOrigin(origins = "http://localhost:4200")
public class FileupdateController {

    private final FileupdateService fileupdateService;

    private final OrderService orderService;

    @Autowired
    myutils _utils;


    public FileupdateController(FileupdateService fileupdateService, OrderService orderService) {
        this.fileupdateService = fileupdateService;
        this.orderService = orderService;
    }


    //@PutMapping("/byId/{id}")
    @PostMapping("/byId")
    public void updateFileInfo(@RequestBody Fileupdate myFileUpdate) {
    //public void updateFileInfo(@PathVariable String id, @RequestBody Fileupdate myFileUpdate) {
        Order order = null;
        log.info(myFileUpdate.getFileAppraiser());
        order = this.orderService.getOrderById(myFileUpdate.getFileId());

        order.setNewfile_appraiser(myFileUpdate.getFileAppraiser());
        order.setNewfile_status(_utils.get_FileStatus("Appraiser Assigned"));

        log.info(order.getNewfile_appraiser());


        this.fileupdateService.updateAppraiser(order);
    }



}
