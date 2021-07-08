package com.pubaoyou.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: eric
 * @Date: 2021/7/7 10:39
 * @Version 1.0
 */
@Service
@FeignClient(name="PUBAOYOU-SERVICE")
public interface UserLoginService {

    /**
     * 查询用户信息
     * @return
     */
    @GetMapping("/user/v1/getUserInfo")
    public String getUserInfo();

}
