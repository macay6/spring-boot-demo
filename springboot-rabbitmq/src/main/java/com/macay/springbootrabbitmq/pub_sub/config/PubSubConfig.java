package com.macay.springbootrabbitmq.pub_sub.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: PubSubConfig
 * @Description:
 * @Author: Macay
 * @Date: 2022/1/9 11:38 上午
 */
@Configuration
public class PubSubConfig {

    public static final String FANOUT_EXC = "fanoutExchange";

    // 创建队列
    @Bean
    public Queue queueA() {
        return new Queue("queue_A");
    }

    @Bean
    public Queue queueB() {
        return new Queue("queue_B");
    }

    //创建一个fanoutExchange交换机
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    //将queueA队列绑定到fanoutExchange交换机上面
    @Bean
    Binding bindingExchangeMessageFanoutA(Queue queueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    //将queueB队列绑定到fanoutExchange交换机上面
    @Bean
    Binding bindingExchangeMessageFanoutB(Queue queueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }
}
