package com.pubaoyou.eric.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pubaoyou/native/v1")
@RestController
public class NativeController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String nativeLogin() throws Exception{
        return "hello,spring native!";
    }

}
