package com.pubaoyou.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping("/service/user/login/v1/queryUserAccount")
    public String queryUserAccount(@RequestParam String userName,@RequestParam String password);

}
