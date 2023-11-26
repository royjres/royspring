package com.jrs.appraisal.connect.service;
import com.jrs.appraisal.connect.model.User;
import com.jrs.appraisal.connect.model.Userlogged;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public void createUser(User user);

    public List<User> getUsers();

    public User getUserById(String userid);

    public User getAuthenticatedUser(String userName);
}
