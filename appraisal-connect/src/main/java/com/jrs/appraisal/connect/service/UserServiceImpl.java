package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.model.User;
import com.jrs.appraisal.connect.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public void createUser(User user) {

        log.info("Saving user....");
        try {

            userRepository.save(user);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        User user = null;
        try {
            user = userRepository.findById(id).get();
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

}
