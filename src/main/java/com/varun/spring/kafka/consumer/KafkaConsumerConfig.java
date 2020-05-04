package com.varun.spring.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

/**
 * This class is NEEDED ONLY WHEN YOU WANT TO FILTER
 */
@Configuration
public class KafkaConsumerConfig {
    @Autowired
    private ConsumerFactory consumerFactory;
    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer, String> createFilterConsumerFactory(){
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setRecordFilterStrategy(
                record -> record.key()%2==0); //leave out all even numbers
        return factory;
    }

}
