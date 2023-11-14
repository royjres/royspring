package com.jrs.appraisal.connect.controller;

import com.jrs.appraisal.connect.model.User;
import com.jrs.appraisal.connect.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        log.info("Create user {}", user);
        userService.createUser(user);

        return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/retrieve")
    public List<User> getUsers(){
        log.info("retrieve all users");
        return userService.getUsers();
    }

    @GetMapping("/byId/{id}")
    public User getUser(@PathVariable String id){
        log.info("get user by id ");
        return userService.getUserById(id);
    }
}
