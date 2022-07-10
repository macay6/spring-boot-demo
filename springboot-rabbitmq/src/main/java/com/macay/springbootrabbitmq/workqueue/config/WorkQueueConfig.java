package com.macay.springbootrabbitmq.workqueue.config;

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
public class WorkQueueConfig {

    public static final String QUEUE = "work_queue_test_queue";

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE);
    }
}
