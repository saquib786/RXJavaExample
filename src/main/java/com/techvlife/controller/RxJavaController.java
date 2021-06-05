package com.techvlife.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techvlife.impl.RxJavaServiceEx1Impl;
import com.techvlife.impl.RxJavaServiceEx2Impl;
import com.techvlife.impl.RxJavaServiceEx3Impl;
import com.techvlife.impl.RxJavaServiceEx4Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RxJavaController {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RxJavaServiceEx1Impl rxJavaServiceEx1;
    @Autowired
    private RxJavaServiceEx2Impl rxJavaServiceEx2;
    @Autowired
    private RxJavaServiceEx3Impl rxJavaServiceEx3;
    @Autowired
    private RxJavaServiceEx4Impl rxJavaServiceEx4;

    @RequestMapping(value = "/first",method = RequestMethod.GET)
    public String executeExampleOne(){
        try{
            rxJavaServiceEx1.process();
            return objectMapper.writeValueAsString("Hello, This is Example 1. Check Execution order in Logs");
        }catch (JsonProcessingException ex){
            return "Error Occurred";
        }
    }

    @GetMapping(value = "/second")
    public String executeExampleTwo(){
        try {
            rxJavaServiceEx2.process();
            return objectMapper.writeValueAsString("Hello, This is Example 2. Check Execution order in Logs");
        } catch (JsonProcessingException e) {
            return "Error Occurred";
        }
    }

    @GetMapping(value = "/third")
    public String executeExampleThree(){
        try {
            rxJavaServiceEx3.process();
            return objectMapper.writeValueAsString("Hello, This is Example 3. Check Execution order in Logs");
        } catch (JsonProcessingException e) {
            return "Error Occurred";
        }
    }

    @GetMapping(value = "/fourth")
    public String executeExampleFour(){
        try {
            rxJavaServiceEx4.process();
            return objectMapper.writeValueAsString("Hello, This is Example 4. Check Execution order in Logs");
        } catch (JsonProcessingException e) {
            return "Error Occurred";
        }
    }


}
