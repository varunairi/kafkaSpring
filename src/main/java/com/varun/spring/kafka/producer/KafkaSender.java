package com.varun.spring.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

    private KafkaTemplate<Integer,String> template;
    @Autowired
    public void setTemplate(KafkaTemplate<Integer, String> template)
    {this.template = template;}

    public void sendMessage(String message){

        for (int i = 0; i <14 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sending Message: ");
            template.send("mySpringTopic",message + " " + i);
        }
    }
}
