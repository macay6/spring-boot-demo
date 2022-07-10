package com.macay.springbootrabbitmq.pub_sub.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HelloWorldConsumer
 * @Description:
 * @Author: Macay
 * @Date: 2022/1/8 4:21 下午
 */
@Component
public class PubSubConsumer {

    @RabbitListener(queues = "queue_A")
    public void receive1(String msg) {
        System.out.println("consumer1 msg is :" + msg);
    }

    @RabbitListener(queues = "queue_B")
    public void receive2(String msg){
        System.out.println("consumer2 msg is :" + msg);
    }
}
