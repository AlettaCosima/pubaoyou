package com.pubaoyou;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: eric
 * @Date: 2021/6/10 15:31
 * @Version 1.0
 */

@SpringBootApplication
@MapperScan(basePackages = "com.pubaoyou.dao.mapper")
public class WebRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebRunner.class, args);
    }

}
