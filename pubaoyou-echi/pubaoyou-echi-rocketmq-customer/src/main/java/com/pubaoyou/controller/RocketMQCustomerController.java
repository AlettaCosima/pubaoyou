package com.pubaoyou.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(topic = "springboot-mq",consumerGroup = "springboot-mq-consumer-1",consumeMode = ConsumeMode.CONCURRENTLY)
public class RocketMQCustomerController implements RocketMQReplyListener {

    @Override
    public Object onMessage(Object message) {
        log.info("Receive message："+message);
        return message;
    }
}
