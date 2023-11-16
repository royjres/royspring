package com.jrs.appraisal.connect.controller;

import com.jrs.appraisal.connect.model.Fileupdate;
import com.jrs.appraisal.connect.model.Order;
import com.jrs.appraisal.connect.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.jrs.appraisal.connect.service.FileupdateService;

@Slf4j
@RestController
@RequestMapping("/fileupdate")
@CrossOrigin(origins = "http://localhost:4200")
public class FileupdateController {

    private final FileupdateService fileupdateService;

    private final OrderService orderService;

    public FileupdateController(FileupdateService fileupdateService, OrderService orderService) {
        this.fileupdateService = fileupdateService;
        this.orderService = orderService;
    }


    @PutMapping("/byId/{id}")
    public void updateFileInfo(@PathVariable String id, @RequestBody Fileupdate myFileUpdate) {
        Order order = null;

        order = this.orderService.getOrderById(myFileUpdate.getFileId());

        order.setNewfile_appraiser(myFileUpdate.getFileAppraiser());
        order.setNewfile_status("APPRAISER ASSIGNED");

        this.fileupdateService.updateAppraiser(order);
    }



}
