package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.model.Fileupdate;
import com.jrs.appraisal.connect.model.Order;
import com.jrs.appraisal.connect.model.Vlog;
import com.jrs.appraisal.connect.repository.OrderRepository;
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
    VlogService vlogService;

    @Autowired
    FileexceptionService fileexceptionService;


    @Autowired
    myutils _utils;


    @Override
    public void updateAppraiser(Fileupdate myFileUpdate) {

        //UPDATE ORDER
        Order order = null;
        String myAppraiser = "";
        String myReviewer = "";

        String myTimestamp = _utils.get_timestamp();
        String myDate = myTimestamp.substring(0,8);
        String myTime = myTimestamp.substring(8,14);
        String myUserId = myFileUpdate.getUserId();

        try {

            myAppraiser = myFileUpdate.getFileAppraiser();
            myReviewer = myFileUpdate.getFileReviewer();

            order = orderRepository.findById(myFileUpdate.getFileId()).get();
            order.setNewfile_appraiser(myAppraiser);
            if ( myReviewer != "" ) {
                if ( myReviewer == null ) {
                    myReviewer = "";
                }
                order.setNewfile_reviewer(myReviewer);
            }
            order.setNewfile_status(_utils.get_FileStatus("Appraiser Assigned"));

            order = orderRepository.save(order);

            //CREATE VLOG

            Vlog myvlog = new Vlog();
            //myvlog.setVlogOrdId(order.getOrdId());
            myvlog.setVlogDescription( ("Appraiser Assigned: " + myAppraiser).toUpperCase());
            myvlog.setVlogUser(myUserId);
            myvlog.setVlogDate(myDate);
            myvlog.setVlogTime(myTime);
            myvlog.setVlogUserLevel("2");
            myvlog.setVlogFileId(myFileUpdate.getFileId());
            vlogService.createVlog(myvlog);

            fileexceptionService.clearException(myFileUpdate.getFileId());


        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            if ( myReviewer != "") {
                order.setNewfile_reviewer(myReviewer);

                //CREATE VLOG

                Vlog myvlog = new Vlog();
                //myvlog.setVlogOrdId(order.getOrdId());
                myvlog.setVlogDescription( ("Reviewer Assigned: " + myReviewer).toUpperCase());
                myvlog.setVlogUser(myUserId);
                myvlog.setVlogDate(myDate);
                myvlog.setVlogTime(myTime);
                myvlog.setVlogUserLevel("2");
                myvlog.setVlogFileId(myFileUpdate.getFileId());
                vlogService.createVlog(myvlog);

            }



        } catch (Exception e){
            e.printStackTrace();
        }



    }

    @Override
    public void updateAppointmentNotification(Fileupdate myFileUpdate) {

        try {

            //CREATE VLOG
            String myTimestamp = _utils.get_timestamp();
            String myDate = myTimestamp.substring(0,8);
            String myTime = myTimestamp.substring(8,14);
            String myUserId = myFileUpdate.getUserId();


            Vlog myvlog = new Vlog();
            //myvlog.setVlogOrdId(order.getOrdId());
            myvlog.setVlogDescription( (myFileUpdate.getFileAppointmentUpdate()).toUpperCase());
            myvlog.setVlogUser(myUserId);
            myvlog.setVlogDate(myDate);
            myvlog.setVlogTime(myTime);
            myvlog.setVlogUserLevel("2");
            myvlog.setVlogFileId(myFileUpdate.getFileId());
            vlogService.createVlog(myvlog);

            fileexceptionService.clearException(myFileUpdate.getFileId());


        } catch (Exception e){
            e.printStackTrace();
        }



    }

    @Override
    public void updateAppointmentException(Fileupdate myFileUpdate) {

        try {

            //CREATE VLOG
            String myTimestamp = _utils.get_timestamp();
            String myDate = myTimestamp.substring(0,8);
            String myTime = myTimestamp.substring(8,14);
            String myUserId = myFileUpdate.getUserId();

            Vlog myvlog = new Vlog();
            //myvlog.setVlogOrdId(order.getOrdId());
            myvlog.setVlogDescription( (myFileUpdate.getFileAppointmentUpdate()).toUpperCase());
            myvlog.setVlogUser(myUserId);
            myvlog.setVlogDate(myDate);
            myvlog.setVlogTime(myTime);
            myvlog.setVlogUserLevel("2");
            myvlog.setVlogFileId(myFileUpdate.getFileId());
            vlogService.createVlog(myvlog);

            //CREATE EXCEPTION
            fileexceptionService.createException(myFileUpdate.getFileId());

        } catch (Exception e){
            e.printStackTrace();
        }



    }

    @Override
    public void updateAppointmentDate(Fileupdate myFileUpdate) {

        try {

            //UPDATE ORDER
            Order order = null;

            order = orderRepository.findById(myFileUpdate.getFileId()).get();
            order.setNewfile_appointment_datetime(myFileUpdate.getFileAppointment());
            order.setNewfile_status(_utils.get_FileStatus("Insp. Date Confirmed"));

            order = orderRepository.save(order);

            //CREATE VLOG
            String myTimestamp = _utils.get_timestamp();
            String myDate = myTimestamp.substring(0,8);
            String myTime = myTimestamp.substring(8,14);
            String myUserId = myFileUpdate.getUserId();


            Vlog myvlog = new Vlog();
            //myvlog.setVlogOrdId(order.getOrdId());
            myvlog.setVlogDescription( ("Insp. Date Confirmed").toUpperCase());
            myvlog.setVlogUser(myUserId);
            myvlog.setVlogDate(myDate);
            myvlog.setVlogTime(myTime);
            myvlog.setVlogUserLevel("2");
            myvlog.setVlogFileId(myFileUpdate.getFileId());
            vlogService.createVlog(myvlog);

            fileexceptionService.clearException(myFileUpdate.getFileId());


        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateInspectionComplete(Fileupdate myFileUpdate) {

        try {

            String myTimestamp = _utils.get_timestamp();
            String myDate = myTimestamp.substring(0,8);
            String myTime = myTimestamp.substring(8,14);
            String myUserId = myFileUpdate.getUserId();


            //UPDATE ORDER
            Order order = null;

            order = orderRepository.findById(myFileUpdate.getFileId()).get();
            order.setNewfile_inspection_complete(myDate + myTime);
            order.setNewfile_status(_utils.get_FileStatus("Insp. Completed"));

            order = orderRepository.save(order);

            //CREATE VLOG

            Vlog myvlog = new Vlog();
            //myvlog.setVlogOrdId(order.getOrdId());
            myvlog.setVlogDescription( ("Insp. Completed").toUpperCase());
            myvlog.setVlogUser(myUserId);
            myvlog.setVlogDate(myDate);
            myvlog.setVlogTime(myTime);
            myvlog.setVlogUserLevel("2");
            myvlog.setVlogFileId(myFileUpdate.getFileId());
            vlogService.createVlog(myvlog);

            fileexceptionService.clearException(myFileUpdate.getFileId());


        } catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void updateReportSubmitted(Fileupdate myFileUpdate) {

        try {

            String myTimestamp = _utils.get_timestamp();
            String myDate = myTimestamp.substring(0,8);
            String myTime = myTimestamp.substring(8,14);
            String myUserId = myFileUpdate.getUserId();


            //UPDATE ORDER
            Order order = null;

            order = orderRepository.findById(myFileUpdate.getFileId()).get();
            order.setNewfile_report_submitted(myDate + myTime);
            order.setNewfile_status(_utils.get_FileStatus("Pending Review"));

            order = orderRepository.save(order);

            //CREATE VLOG

            Vlog myvlog = new Vlog();
            //myvlog.setVlogOrdId(order.getOrdId());
            myvlog.setVlogDescription( ("Report Submitted - Pending Review").toUpperCase());
            myvlog.setVlogUser(myUserId);
            myvlog.setVlogDate(myDate);
            myvlog.setVlogTime(myTime);
            myvlog.setVlogUserLevel("2");
            myvlog.setVlogFileId(myFileUpdate.getFileId());
            vlogService.createVlog(myvlog);

            fileexceptionService.clearException(myFileUpdate.getFileId());


        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateReportRejected(Fileupdate myFileUpdate) {

        try {

            String myTimestamp = _utils.get_timestamp();
            String myDate = myTimestamp.substring(0,8);
            String myTime = myTimestamp.substring(8,14);
            String myUserId = myFileUpdate.getUserId();

            //UPDATE ORDER
            Order order = null;

            order = orderRepository.findById(myFileUpdate.getFileId()).get();
            order.setNewfile_inspection_complete(myDate + myTime);
            order.setNewfile_status(_utils.get_FileStatus("Report Rejected"));

            order = orderRepository.save(order);

            //CREATE VLOG

            Vlog myvlog = new Vlog();
            //myvlog.setVlogOrdId(order.getOrdId());
            myvlog.setVlogDescription( ("Report Rejected").toUpperCase());
            myvlog.setVlogUser(myUserId);
            myvlog.setVlogDate(myDate);
            myvlog.setVlogTime(myTime);
            myvlog.setVlogUserLevel("2");
            myvlog.setVlogFileId(myFileUpdate.getFileId());
            vlogService.createVlog(myvlog);

            //CREATE EXCEPTION
            fileexceptionService.createException(myFileUpdate.getFileId());


        } catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void updateFileClosed(Fileupdate myFileUpdate) {

        try {

            String myTimestamp = _utils.get_timestamp();
            String myDate = myTimestamp.substring(0,8);
            String myTime = myTimestamp.substring(8,14);
            String myUserId = myFileUpdate.getUserId();


            //UPDATE ORDER
            Order order = null;

            order = orderRepository.findById(myFileUpdate.getFileId()).get();
            order.setNewfile_fileclosed(myDate + myTime);
            order.setNewfile_status(_utils.get_FileStatus("File Closed"));

            order = orderRepository.save(order);

            //CREATE VLOG

            Vlog myvlog = new Vlog();
            //myvlog.setVlogOrdId(order.getOrdId());
            myvlog.setVlogDescription( ("File Closed").toUpperCase());
            myvlog.setVlogUser(myUserId);
            myvlog.setVlogDate(myDate);
            myvlog.setVlogTime(myTime);
            myvlog.setVlogUserLevel("2");
            myvlog.setVlogFileId(myFileUpdate.getFileId());
            vlogService.createVlog(myvlog);

            fileexceptionService.clearException(myFileUpdate.getFileId());


        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
