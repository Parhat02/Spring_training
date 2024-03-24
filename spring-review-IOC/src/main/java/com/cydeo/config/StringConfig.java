package com.cydeo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringConfig {
    @Bean//(name = "Welcome")
    public String str1(){
        return "Welcome to Cydeo";
    }

    @Bean//(name = "Spring")
    public String str2(){
        return "Spring Core Practice";
    }

}
