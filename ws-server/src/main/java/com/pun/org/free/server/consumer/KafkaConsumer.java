package com.pun.org.free.server.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(id = "myId", topics = "topic1")
    public void listen(String in) {
        log.info("Successfully consumed from Kafka: {}", in);
    }
}
