package com.pubaoyou.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQLocalRequestCallback;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/rocketmq/provider/")
@Slf4j
public class RocketMqProviderController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping(value = "/rocketmqProvider",method = RequestMethod.GET)
    public String rocketmqProvider(){
        //直接发送，无需确认消费是否收到；convertSendAndReceive则需要消费者确认才能发送下一条消息
        //rocketMQTemplate.convertAndSend("springboot-mq","hello rocketMQ!!!");
        //确认机制，确认消费端是否收到消息并进行业务处理
        rocketMQTemplate.sendAndReceive("springboot-mq","hello rocketMQ!!!",new RocketMQLocalRequestCallback(){

            @Override
            public void onSuccess(Object o) {
                log.info("rocketmq send message is success,and Received message:{}",o.toString());
            }

            @Override
            public void onException(Throwable throwable) {
                log.error("rocketmq send message is failed,and error msg is:{}",throwable.getMessage());
            }
        });

        //
        return "success";
    }

}
