package com.pubaoyou.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/rabbitmq/v1")
public class RabbitmqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/sendMsg")
    public String sendMsg() throws Exception{

        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功："+orderId);

        //3.通过MQ来完成消息的分发

        //参数1：交换机 参数2：路由key/queue队列名称 参数3：消息内容
        String exchangeName = "fanout_fsg_exchange";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId);

        return "success";
    }

    @RequestMapping("/sendMsgDirect")
    public String sendMsgDirect() throws Exception{

        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功："+orderId);

        //3.通过MQ来完成消息的分发

        //参数1：交换机 参数2：路由key/queue队列名称 参数3：消息内容
        String exchangeName = "direct_fsg_exchange";
        String routingKey = "fsg.one";
        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId);

        return "success";
    }

    @RequestMapping("/sendMsgTopic")
    public String sendMsgTopic() throws Exception{

        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功："+orderId);

        //3.通过MQ来完成消息的分发

        //参数1：交换机 参数2：路由key/queue队列名称 参数3：消息内容
        String exchangeName = "topic_fsg_exchange";
//        String routingKey = "topic.two";
        rabbitTemplate.convertAndSend(exchangeName,"add.*",orderId);
        rabbitTemplate.convertAndSend(exchangeName,"topic.one",orderId);
        rabbitTemplate.convertAndSend(exchangeName,"topic.two.three",orderId);
        rabbitTemplate.convertAndSend(exchangeName,"fsg.topic.two",orderId);

        return "success";
    }

}
