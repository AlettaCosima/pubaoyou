package com.pubaoyou.service.user;

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

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam String userName, String password){
        return "login success";
    }

}
