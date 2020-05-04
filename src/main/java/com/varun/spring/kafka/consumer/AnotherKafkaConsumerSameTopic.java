package com.varun.spring.kafka.consumer;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
@Configuration
public class AnotherKafkaConsumerSameTopic {

 //  @KafkaListener(topics = "mySpringTopic")
    public void recieveMessage(String message,
                               @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                               @Header(KafkaHeaders.OFFSET) int offset) {
        StringBuilder sb = new StringBuilder();
        sb.append("Listener 1: Offset: ").append(offset).append(" Partition:").append(partition).append(" with Message:").append(message);

        System.out.println("Recieved: " + sb.toString());
    }
}
