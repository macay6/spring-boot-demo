package com.macay.springbootrabbitmq;

import com.macay.springbootrabbitmq.topic.config.TopicConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TopicProduceTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void topicTest() {
        rabbitTemplate.convertAndSend(TopicConfig.TOPIC_EXC,
                "xiaomi.news","小米新闻..");
        rabbitTemplate.convertAndSend(TopicConfig.TOPIC_EXC,
                "huawei.news","华为新闻..");
        rabbitTemplate.convertAndSend(TopicConfig.TOPIC_EXC,
                "xiaomi.phone","小米手机..");
        rabbitTemplate.convertAndSend(TopicConfig.TOPIC_EXC,
                "huawei.phone","华为手机..");
        rabbitTemplate.convertAndSend(TopicConfig.TOPIC_EXC,
                "phone.news","手机新闻..");
    }
}
