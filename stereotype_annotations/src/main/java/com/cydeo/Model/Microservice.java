package com.cydeo.Model;

import org.springframework.stereotype.Component;

@Component
public class Microservice {

    private final ExtraHours extraHours;

    public Microservice(ExtraHours extraHours) {
        this.extraHours = extraHours;
    }

    public void getTotalHours(){
        System.out.println("Total hours : " + (25+extraHours.getHours()));
    }
}
