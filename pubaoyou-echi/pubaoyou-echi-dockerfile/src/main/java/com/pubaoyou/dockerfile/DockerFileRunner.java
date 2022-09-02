package com.pubaoyou.dockerfile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DockerFileRunner {

    public static void main(String[] args) {
        log.info("flunte test springboot application init start");
        SpringApplication.run(DockerFileRunner.class,args);
        log.info("flunte test springboot application init success");
    }
}
