package org.cydeo.spring08mvccontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/student")
    public String getStudentInfo(){
        return "student/welcome.html";
    }
}
