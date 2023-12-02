package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.model.Fileexception;
import com.jrs.appraisal.connect.model.Fileupdate;
import com.jrs.appraisal.connect.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileexceptionService {

    public void createException(String myFileId);

    public List<Fileexception> getExceptions();

    public void clearException(String myFileId);

}
