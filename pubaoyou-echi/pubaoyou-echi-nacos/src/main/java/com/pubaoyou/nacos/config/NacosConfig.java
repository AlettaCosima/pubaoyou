package com.pubaoyou.nacos.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/nacos/config/v1")
@RestController
@RefreshScope
public class NacosConfig {

    @Value("${url}")
    private String url;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @RequestMapping("/getMessage")
    public String getMessage(){
        return "url:" + url + "</br>username:" + username + "</br>password:" + password;
    }

}
