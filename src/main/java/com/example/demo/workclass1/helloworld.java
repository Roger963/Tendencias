package com.example.demo.workclass1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping
public class helloworld {
    @GetMapping("/")
    public String getMethodName() {
        return "hello world";
    }
    
}