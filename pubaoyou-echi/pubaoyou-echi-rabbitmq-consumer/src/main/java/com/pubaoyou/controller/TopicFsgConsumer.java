package com.pubaoyou.controller;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "fsg.one.topic.queue",durable = "false",autoDelete = "true"),
        exchange = @Exchange(value = "topic_fsg_exchange",type = ExchangeTypes.TOPIC),
        key = "topic.one"
))
public class TopicFsgConsumer {

    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("fsg topic接收到了的订单信息是：" + message);
    }
}
