package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.model.Vlog;
import com.jrs.appraisal.connect.repository.VlogRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@Transactional
public class VlogServiceImpl implements VlogService {

    @Autowired
    VlogRepository vlogRepository;

    @Override
    public void createVlog(Vlog vlog) {

        log.info("Saving vlog....");
        try {

            vlogRepository.save(vlog);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
