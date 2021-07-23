package com.pubaoyou.gateway.utils;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: eric
 * @Date: 2021/7/8 11:05
 * @Version 1.0
 */
@Configuration
public class FeginConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
