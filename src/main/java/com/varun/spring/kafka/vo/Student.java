package com.varun.spring.kafka.vo;

import org.springframework.boot.jackson.JsonComponent;

public class Student {

    private String name;

    private String classes;

    public Student(){

    }
    public Student(String name, String classes){
        this.name = name;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getClasses();
    }
}
