package org.cydeo.spring08mvccontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage(){   //Which end point?
        return "home.html";
    }

    @RequestMapping("/ozzy")
    public String getHomePage2(){
        return "home.html";
    }

    @RequestMapping //default / nothing
    public String getHomePage3(){
        return "home.html";
    }

    @RequestMapping({"/apple", "/orange"})
    public String getHomePage4(){   //Which end point?
        return "home.html";
    }

}
