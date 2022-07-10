package com.macay.springbootrabbitmq.routing.config;

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
public class RoutingConfig {

    public static final String DIRECT_EXC = "direct_rout_Exchange";

    public static final String QUEUE_DIRECT_A = "direct.A";

    public static final String QUEUE_DIRECT_B = "direct.B";

    // 创建队列
    @Bean
    public Queue queueDirectNameA() {
        return new Queue(QUEUE_DIRECT_A);
    }

    @Bean
    public Queue queueDirectNameB() {
        return new Queue(QUEUE_DIRECT_B);
    }

    // 创建一个directExchange交换机
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXC);
    }

    // 将direct.A队列绑定到directExchange交换机中，使用direct.a.key作为路由规则
    @Bean
    Binding bindingExchangeMessageDirectA(Queue queueDirectNameA, DirectExchange directExchange) {
        return BindingBuilder.bind(queueDirectNameA).to(directExchange).with("direct.a.key");
    }

    // 将direct.B队列绑定到directExchange交换机中，使用direct.b.key作为路由规则
    @Bean
    Binding bindingExchangeMessageDirectB(Queue queueDirectNameB, DirectExchange directExchange) {
        return BindingBuilder.bind(queueDirectNameB).to(directExchange).with("direct.b.key");
    }
}
