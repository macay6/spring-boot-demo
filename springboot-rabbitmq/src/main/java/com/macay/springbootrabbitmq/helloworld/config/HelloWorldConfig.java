package com.macay.springbootrabbitmq.helloworld.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: HelloWorldConfig
 * @Description:
 * @Author: Macay
 * @Date: 2022/1/8 4:11 下午
 */
@Configuration
public class HelloWorldConfig {

    public static final String QUEUE = "hello_world_test_queue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }
}
