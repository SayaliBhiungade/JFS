package com.telstra.springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @RequestMapping(value = "/home" , method= RequestMethod.GET)
    //@GetMapping("/")
    public String helloWorld() {
        return("<h1>hello world</h1>");
    }


}
