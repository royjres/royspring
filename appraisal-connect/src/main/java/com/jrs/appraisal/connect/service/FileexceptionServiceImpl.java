package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.model.Fileexception;
import com.jrs.appraisal.connect.repository.FileexceptionRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class FileexceptionServiceImpl implements FileexceptionService {

    @Autowired
    FileexceptionRepository fileexceptionRepository;


    @Override
    public void createException(String myFileId) {

        Fileexception fileexception = new Fileexception();
        fileexception.setFileexceptionId(myFileId);

        log.info("Saving exception....");
        try {
            //CREATE EXCEPTION
           fileexceptionRepository.save(fileexception);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Fileexception> getExceptions() {
        return fileexceptionRepository.findAll();
    }

    @Override
    public void clearException(String myFileId) {

        Fileexception myException = null;

        try {
            //CREATE EXCEPTION
            myException = fileexceptionRepository.findById(myFileId).get();

            if (!( myException == null )) {
                log.info("Removing exception....");
                fileexceptionRepository.delete(myException);
            }


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
