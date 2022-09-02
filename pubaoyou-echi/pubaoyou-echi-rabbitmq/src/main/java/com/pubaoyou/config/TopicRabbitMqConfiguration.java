package com.pubaoyou.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicRabbitMqConfiguration {

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topic_fsg_exchange",true,false);
    }
    //2.声明队列
    @Bean
    public Queue topicSmsQueue(){
        return new Queue("fsg.one.topic.queue",true);
    }
    @Bean
    public Queue topicDuanxinQueue(){
        return new Queue("fsg.two.topic.queue",true);
    }
    @Bean
    public Queue topicEmailQueue(){
        return new Queue("fsg.three.topic.queue",true);
    }


    //3.完成绑定关系   队列和交换机  的绑定
//    direct  多了一个 路由key  reoutingKey   分类的概念

    @Bean
    public Binding topicSmsBingding(){
        return BindingBuilder.bind(topicSmsQueue()).to(topicExchange()).with("topic.#");
    }
    @Bean
    public Binding topicDuanxinBingding(){
        return BindingBuilder.bind(topicDuanxinQueue()).to(topicExchange()).with("*.add");
    }
    @Bean
    public Binding topicEmailBingding() {
        return BindingBuilder.bind(topicEmailQueue()).to(topicExchange()).with("#.add");

    }
}
