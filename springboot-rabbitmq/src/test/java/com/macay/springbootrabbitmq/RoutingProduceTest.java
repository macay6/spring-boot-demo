package com.macay.springbootrabbitmq;

import com.macay.springbootrabbitmq.routing.config.RoutingConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RoutingProduceTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg() {
        for (int i = 0; i < 2; i++) {
            // 往directExchange交换机中发送消息，使用direct.a.key作为路由规则。
        rabbitTemplate.convertAndSend(RoutingConfig.DIRECT_EXC, "direct.a.key", "pub sub hello world" + i);
        }
    }
}
