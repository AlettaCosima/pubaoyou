package com.pubaoyou.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: eric
 * @Date: 2021/6/11 13:39
 * @Version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class ServiceRunner {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRunner.class, args);
    }
}
