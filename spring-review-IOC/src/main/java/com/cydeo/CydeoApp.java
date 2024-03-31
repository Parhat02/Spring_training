package com.cydeo;

import com.cydeo.bean_practice.FullTimeEmployee;
import com.cydeo.bean_practice.PartTimeEmployee;
import com.cydeo.config.AppConfig;
import com.cydeo.config.StringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class, StringConfig.class);

        FullTimeEmployee fullTimeEmployee =container.getBean(FullTimeEmployee.class);
        PartTimeEmployee partTimeEmployee = container.getBean(PartTimeEmployee.class);

        fullTimeEmployee.createAccount();
        partTimeEmployee.createAccount();

        String str1 = container.getBean("str1",String.class);
        String str2 = container.getBean("str2",String.class);

        System.out.println(str1);
        System.out.println(str2);


    }
}
