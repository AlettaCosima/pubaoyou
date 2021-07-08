package com.pubaoyou.api.controller;

import com.pubaoyou.api.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: eric
 * @Date: 2021/7/7 9:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/user/customer/v1")
public class UserLoginController {

    @Resource
    private UserLoginService userLoginService;

    @RequestMapping("/queryUserAccount")
    public String queryUserAccount(@RequestParam String userName,@RequestParam String password){
        try {
            return userLoginService.queryUserAccount(userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login error";
    }
}
