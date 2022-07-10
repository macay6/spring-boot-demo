package com.macay.springbootrabbitmq.helloworld.consumer;

import com.macay.springbootrabbitmq.helloworld.config.HelloWorldConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HelloWorldConsumer
 * @Description:
 * @Author: Macay
 * @Date: 2022/1/8 4:21 下午
 */
@Component
public class HelloWorldConsumer {

    @RabbitListener(queues = HelloWorldConfig.QUEUE)
    public void receive(String msg) {
        System.out.println("consumer msg is :" + msg);
    }
}
