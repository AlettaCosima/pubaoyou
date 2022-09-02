package com.pubaoyou.seate.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApiRunner.class,args);
    }

}
