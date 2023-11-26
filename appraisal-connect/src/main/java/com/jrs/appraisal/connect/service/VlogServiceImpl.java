package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.model.User;
import com.jrs.appraisal.connect.model.Vlog;
import com.jrs.appraisal.connect.repository.UserRepository;
import com.jrs.appraisal.connect.repository.VlogRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@Service
@Slf4j
@Transactional
public class VlogServiceImpl implements VlogService {

    @Autowired
    VlogRepository vlogRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void createVlog(Vlog vlog) {

        log.info("Saving vlog....");
        try {
            vlog.setUser(userRepository.findById(vlog.getVlogUser()).get());
            vlogRepository.save(vlog);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Vlog> getVlogsById(String id) {

        return vlogRepository.findByVlogFileId(id);
    }


}
