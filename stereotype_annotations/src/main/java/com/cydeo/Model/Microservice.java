package com.cydeo.Model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@Data
public class Microservice {

    @NonNull //this field is required
    private ExtraHours extraHours;

//    public Microservice(ExtraHours extraHours) {
//        this.extraHours = extraHours;
//    }

    public void getTotalHours(){
        System.out.println("Total hours : " + (25+extraHours.getHours()));
    }
}
