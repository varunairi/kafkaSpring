package com.varun.spring.kafka.producer;

import com.varun.spring.kafka.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafkaSender {

    private KafkaTemplate<Integer,Student> template;
    @Autowired
    public void setTemplate(KafkaTemplate<Integer, Student> template)
    {this.template = template;}

    public void sendMessage(String message){

        for (int i = 0; i <14 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sending Message: ");
            //Add Listenable Future to get notified. Also in other examples I was not sneding key
            ListenableFuture<SendResult<Integer, Student>> future = template.send("mySpringTopic",i,
                    new Student(message + " " + i,"BCOM"));

            future.addCallback(s ->System.out.println("Success" + s.getProducerRecord().partition()), f->
                System.out.println("Failure" + f.getLocalizedMessage()));
            // OR WAIT SYNCHRONOUSLY
            // future.get();
        }
    }
}
