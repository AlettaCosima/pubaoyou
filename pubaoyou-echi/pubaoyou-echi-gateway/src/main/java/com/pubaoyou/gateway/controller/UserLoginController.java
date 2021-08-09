package com.pubaoyou.gateway.controller;

import com.pubaoyou.gateway.service.UserLoginService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Api("登录相关接口文档")
public class UserLoginController {

    @Resource
    private UserLoginService userLoginService;

    @RequestMapping("/queryUserAccount")
    @ApiOperation(value = "查询用户",notes = "查询用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",paramType = "query",value = "用户名",dataType = "String",example = "chentao"),
            @ApiImplicitParam(name = "password",paramType = "query",value = "密码",dataType = "String",example = "123456")
    })
    public String queryUserAccount(@RequestParam String userName,@RequestParam String password){
        try {
            log.info("传入用户名为{}，传入密码为{}",userName,password);
            return userLoginService.queryUserAccount(userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login error";
    }
}
