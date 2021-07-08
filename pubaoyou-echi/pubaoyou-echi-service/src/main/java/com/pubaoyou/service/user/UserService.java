package com.pubaoyou.service.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: eric
 * @Date: 2021/6/11 16:18
 * @Version 1.0
 */
@RestController
@RequestMapping("/user/v1")
public class UserService {

    @GetMapping("/getUserInfo")
    public String getUserInfo(){
        System.out.println("222222222222");
        return "login success";
    }

}
