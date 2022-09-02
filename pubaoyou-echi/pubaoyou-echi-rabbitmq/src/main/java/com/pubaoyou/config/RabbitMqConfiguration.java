package com.pubaoyou.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitMqConfiguration{
    //1.声明注册fanout模式的交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout_fsg_exchange",true,false);
    }
    //2.声明队列
    @Bean
    public Queue fsgQueue(){
        return new Queue("fsg.fanout.queue",true);
    }

    //3.完成绑定关系   队列和交换机  的绑定
    @Bean
    public Binding fsgBingding(){
        return BindingBuilder.bind(fsgQueue()).to(fanoutExchange());
    }

}

