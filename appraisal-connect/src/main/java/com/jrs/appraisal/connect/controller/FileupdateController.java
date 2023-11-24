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


        switch(myFileUpdate.getFileAction()) {
            case "assignappraiser":
                this.fileupdateService.updateAppraiser(myFileUpdate);
                break;
            case "appointmentupdate":
                this.fileupdateService.updateAppointmentNotification(myFileUpdate);
                break;
            case "appointmentexception":
                this.fileupdateService.updateAppointmentException(myFileUpdate);
                break;
            case "appointmentdate":
                this.fileupdateService.updateAppointmentDate(myFileUpdate);
                break;
            case "inspectioncomplete":
                this.fileupdateService.updateInspectionComplete(myFileUpdate);
                break;
            case "reportsubmitted":
                this.fileupdateService.updateReportSubmitted(myFileUpdate);
                break;
            case "reportrejected":
                this.fileupdateService.updateReportRejected(myFileUpdate);
                break;
            case "fileclosed":
                this.fileupdateService.updateFileClosed(myFileUpdate);
                break;
        }


    }



}
