package com.macay.springbootrabbitmq;

import com.macay.springbootrabbitmq.pub_sub.config.PubSubConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PubSubProduceTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg() {
        for (int i = 0; i < 2; i++) {
        rabbitTemplate.convertAndSend(PubSubConfig.FANOUT_EXC, null, "pub sub hello world" + i);
        }
    }
}
