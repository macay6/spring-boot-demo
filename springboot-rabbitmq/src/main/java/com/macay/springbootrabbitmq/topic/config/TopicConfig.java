package com.macay.springbootrabbitmq.topic.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: PubSubConfig
 * @Description:
 * @Author: Macay
 * @Date: 2022/1/9 11:38 上午
 */
@Configuration
public class TopicConfig {

    public static final String TOPIC_EXC = "topic_Exchange";

    public static final String XIAOMI = "xiaomi";

    public static final String HUAWEI = "huawei";

    public static final String PHONE = "phone";


    // 创建队列
    @Bean
    public Queue xiaomi() {
        return new Queue(XIAOMI);
    }

    @Bean
    public Queue huawei() {
        return new Queue(HUAWEI);
    }

    @Bean
    public Queue phone() {
        return new Queue(PHONE);
    }


    // 创建一个directExchange交换机
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXC);
    }

    @Bean
    Binding xiaomiBinding() {
        return BindingBuilder.bind(xiaomi()).to(topicExchange())
                .with("xiaomi.#");
    }

    @Bean
    Binding huaweiBinding() {
        return BindingBuilder.bind(huawei()).to(topicExchange())
                .with("huawei.#");
    }
    @Bean
    Binding phoneBinding() {
        return BindingBuilder.bind(phone()).to(topicExchange())
                .with("#.phone.#");
    }
}
