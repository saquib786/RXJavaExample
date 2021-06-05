package com.techvlife.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @RequestMapping(value = "/healthCheck", method = RequestMethod.GET)
    public String healthCheck(){
        return "I am Up and Running";
    }
}
