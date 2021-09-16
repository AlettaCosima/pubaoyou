package com.pubaoyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @Author: eric
 * @Date: 2021/6/11 13:39
 * @Version 1.0
 */

@SpringBootApplication
@MapperScan(basePackages = "com.pubaoyou.dao.mapper")
//@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceRunner {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRunner.class, args);
    }

}
