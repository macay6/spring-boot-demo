package com.macay.springbootrabbitmq;

import com.macay.springbootrabbitmq.helloworld.config.HelloWorldConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldProduceTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg() {
        rabbitTemplate.convertAndSend(HelloWorldConfig.QUEUE, "hello world test");
    }

}
