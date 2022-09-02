package com.pubaoyou.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;


@Configuration
public class DirectRabbitMqConfiguration {

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_fsg_exchange",true,false);
    }
    //2.声明队列
    @Bean
    public Queue directSmsQueue(){
        return new Queue("fsg.one.direct.queue",true);
    }
    @Bean
    public Queue directDuanxinQueue(){
        return new Queue("fsg.two.direct.queue",true);
    }
    @Bean
    public Queue directEmailQueue(){
        return new Queue("fsg.three.direct.queue",true);
    }


    //3.完成绑定关系   队列和交换机  的绑定
//    direct  多了一个 路由key  reoutingKey   分类的概念

    @Bean
    public Binding directSmsBingding(){
        return BindingBuilder.bind(directSmsQueue()).to(directExchange()).with("fsg.one");
    }
    @Bean
    public Binding directDuanxinBingding(){
        return BindingBuilder.bind(directDuanxinQueue()).to(directExchange()).with("fsg.two");
    }
    @Bean
    public Binding directEmailBingding() {
        return BindingBuilder.bind(directEmailQueue()).to(directExchange()).with("fsg.three");

    }
}
