package com.pubaoyou.seata.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.pubaoyou.seata.order.mapper")
public class OrderRunner {

    public static void main(String[] args) {
        SpringApplication.run(OrderRunner.class,args);
    }
}
