package com.pubaoyou.seata.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.pubaoyou.seata.account.mapper")
public class AccountRunner {

    public static void main(String[] args) {
        SpringApplication.run(AccountRunner.class,args);
    }
}
