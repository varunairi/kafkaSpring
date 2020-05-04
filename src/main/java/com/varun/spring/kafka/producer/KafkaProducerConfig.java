package com.varun.spring.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Value (value="${bootstrap.servers}")
    private String bootstrapServer;
    @Bean
    public ProducerFactory<Integer,String> createProducerFactory(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,IntegerSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        return new DefaultKafkaProducerFactory<Integer,String>(configs);
    }

    @Bean
    public KafkaTemplate<Integer,String> createKafkaTemplate(){
        return new KafkaTemplate<>(createProducerFactory());
    }

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("mySpringTopic",3,Short.valueOf("1"));
    }

  /*  @Bean
    public NewTopic createTopic1(){
        return new NewTopic("mySpringTopic3",3,Short.valueOf("1"));
    }

    @Bean
    public NewTopic createTopic2(){
        return new NewTopic("mySpringTopic4",3,Short.valueOf("1"));
    }
*/
}
