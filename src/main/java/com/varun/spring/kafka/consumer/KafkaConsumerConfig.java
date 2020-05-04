package com.varun.spring.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerConfig {

    @KafkaListener(groupId = "kafka-bros",topics = "mySpringTopic")
    public void recieveMessage(String message){
        System.out.print("Recieved: " + message);
    }
}
