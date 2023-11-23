package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.dto.OrderDto;
import com.jrs.appraisal.connect.model.Fileupdate;
import com.jrs.appraisal.connect.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface FileupdateService {

    public void updateAppraiser(Fileupdate myFileUpdate);

    public void updateAppointmentNotification(Fileupdate myFileUpdate);

    public void updateAppointmentException(Fileupdate myFileUpdate);

    public void updateAppointmentDate(Fileupdate myFileUpdate);

    public void updateInspectionComplete(Fileupdate myFileUpdate);


}
