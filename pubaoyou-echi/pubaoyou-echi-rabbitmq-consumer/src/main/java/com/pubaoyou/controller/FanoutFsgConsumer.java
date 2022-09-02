package com.pubaoyou.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = {"fsg.fanout.queue"})
public class FanoutFsgConsumer {


    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("fsg fanout接收到了的订单信息是：" + message);

    }
}
