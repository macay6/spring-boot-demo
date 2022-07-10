package com.macay.springbootkafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: KafkaConsumer
 * @Description:
 * @Author: Macay
 * @Date: 2022/7/10 11:49 上午
 */
@Component
public class KafkaConsumer {

    // 指定要监听的 topic
    @KafkaListener(topics = {"TestTopic"})
    public void onMessage1(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费：" + record.topic() + "-" + record.partition() + "-" + record.value());
    }
}
