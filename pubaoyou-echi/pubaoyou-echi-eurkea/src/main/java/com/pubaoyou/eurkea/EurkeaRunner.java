package com.pubaoyou.eurkea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: eric
 * @Date: 2021/6/11 15:49
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurkeaRunner {

    public static void main(String[] args) {
        SpringApplication.run(EurkeaRunner.class,args);
    }
}
