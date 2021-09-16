package com.pubaoyou.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: eric
 * @Date: 2021/6/10 15:19
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class GatewayRunner {
    public static void main(String[] args) {
        SpringApplication.run(GatewayRunner.class, args);
    }
}
