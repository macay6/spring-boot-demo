package com.macay.springbootrabbitmq.topic.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HelloWorldConsumer
 * @Description:
 * @Author: Macay
 * @Date: 2022/1/8 4:21 下午
 */
@Component
public class TopicConsumer {

    @RabbitListener(queues = "phone")
    public void handler1(String message) {
        System.out.println("PhoneReceiver:" + message);
    }
    @RabbitListener(queues = "xiaomi")
    public void handler2(String message) {
        System.out.println("XiaoMiReceiver:"+message);
    }
    @RabbitListener(queues = "huawei")
    public void handler3(String message) {
        System.out.println("HuaWeiReceiver:"+message);
    }
}
