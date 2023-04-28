package com.macay.springbootrabbitmq.workqueue.consumer;

import com.macay.springbootrabbitmq.workqueue.config.WorkQueueConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName: HelloWorldConsumer
 * @Description:
 * @Author: Macay
 * @Date: 2022/1/8 4:21 下午
 */
@Component
public class WorkQueueConsumer {

    @RabbitListener(queues = WorkQueueConfig.QUEUE)
    public void receive1(Message msg, Channel channel) throws IOException {
        System.out.println("consumer1 msg is  :" + msg.getPayload());
        channel.basicAck(((Long) msg.getHeaders().get(AmqpHeaders.DELIVERY_TAG)),true);
    }

    @RabbitListener(queues = WorkQueueConfig.QUEUE, concurrency = "10")
    public void receive2(Message msg, Channel channel) throws IOException {
        System.out.println("consumer2 msg is :" + msg.getPayload() + "------->"+Thread.currentThread().getName());
        channel.basicReject(((Long) msg.getHeaders().get(AmqpHeaders.DELIVERY_TAG)), true);
    }
}
