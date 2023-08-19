package com.springdemo.helloworld.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping
    public String helloWorld() {
        return "Hello World from Spring Boot App Engine on GCP";
    }

}
