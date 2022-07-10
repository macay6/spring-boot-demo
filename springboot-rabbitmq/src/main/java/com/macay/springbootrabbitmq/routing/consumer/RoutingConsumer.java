package com.macay.springbootrabbitmq.routing.consumer;

import com.macay.springbootrabbitmq.routing.config.RoutingConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HelloWorldConsumer
 * @Description:
 * @Author: Macay
 * @Date: 2022/1/8 4:21 下午
 */
@Component
public class RoutingConsumer {

    @RabbitListener(queues = RoutingConfig.QUEUE_DIRECT_A)
    public void receive1(String msg) {
        System.out.println("consumer1 msg is :" + msg);
    }

    @RabbitListener(queues = RoutingConfig.QUEUE_DIRECT_B)
    public void receive2(String msg){
        System.out.println("consumer2 msg is :" + msg);
    }
}
