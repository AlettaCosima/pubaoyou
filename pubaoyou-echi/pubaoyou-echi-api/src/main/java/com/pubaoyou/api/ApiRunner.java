package com.pubaoyou.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: eric
 * @Date: 2021/6/10 15:19
 * @Version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class ApiRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApiRunner.class, args);
    }

}
