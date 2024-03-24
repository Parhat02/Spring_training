package com.cydeo;

import com.cydeo.Model.DataStructure;
import com.cydeo.Model.Microservice;
import com.cydeo.config.CourseConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CourseApp {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(CourseConfig.class);

        DataStructure dataStructure = container.getBean(DataStructure.class);
        Microservice microservice = container.getBean(Microservice.class);

        dataStructure.getTotalHours();
        microservice.getTotalHours();




    }
}
