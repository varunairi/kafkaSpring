package com.varun.spring.kafka;

import com.varun.spring.kafka.producer.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }

    @Autowired
    private KafkaSender sender;
    @Override
    public void run(String... args){
        System.out.println("Sending MEssage to Kafka");
        sender.sendMessage("Hello");
    }
}
