package com.pubaoyou.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.pubaoyou.dao.mapper")
public class DaoRunner {

    public static void main(String[] args) {
        SpringApplication.run(DaoRunner.class, args);
    }

}
