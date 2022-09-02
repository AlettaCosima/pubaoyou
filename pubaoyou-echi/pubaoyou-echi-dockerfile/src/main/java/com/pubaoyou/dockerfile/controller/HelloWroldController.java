package com.pubaoyou.dockerfile.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pubaoyou/dockerfile/v1")
@Slf4j
public class HelloWroldController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloWorld() throws  Exception{
        log.info("hello method of dockerfile application init start");
        return "hello word dockerfile!!!";
    }

}
