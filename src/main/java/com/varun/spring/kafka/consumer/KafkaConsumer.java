package com.varun.spring.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "mySpringTopic",
    containerFactory = "createFilterConsumerFactory")
    /*@KafkaListener(
            topicPartitions = @TopicPartition(topic = "topicName",
                    partitionOffsets = {
                            @PartitionOffset(partition = "0", initialOffset = "0"),
                            @PartitionOffset(partition = "3", initialOffset = "0")
                    }))*/
    /*@KafkaListener(topicPartitions
            = @TopicPartition(topic = "topicName", partitions = { "0", "1" }))*/
    public void recieveMessage(String message,
                               @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                               @Header(KafkaHeaders.OFFSET) int offset){
        StringBuilder sb = new StringBuilder();
        sb.append("Listener 2: Offset: ").append(offset).append(" Partition:").append(partition).append(" with Message:").append(message);

        System.out.println("Received: " + sb.toString());
    }
}
