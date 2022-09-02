package com.pubaoyou.controller;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RabbitListener(queues = {"fsg.one.direct.queue"})
public class DirectFsgConsumer {

    @RabbitHandler
    public void reviceMessage(String msg, Channel channel, Message message) throws IOException {

        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("fsg direct接收到了的订单信息是：" + msg);
        } catch (Exception e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
            System.err.println("fsg direct接收到了的订单信息失败："+msg);
            e.printStackTrace();
            /**
             * 拒绝一条消息：<br>
             * channel.basicReject(long deliveryTag, boolean requeue);<br>
             * deliveryTag:该消息的index<br>
             * requeue：被拒绝的是否重新入队列
             */
            //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
        }

    }
}
