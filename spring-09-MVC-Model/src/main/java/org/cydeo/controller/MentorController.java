package org.cydeo.controller;

import org.cydeo.enums.Gender;
import org.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/list")
    public String mentorPage(Model model){

        List<Mentor> mentors = new ArrayList<>();
        mentors.add(new Mentor("Mike","Smith",45, Gender.MALE));
        mentors.add(new Mentor("Tom","Hanks",65, Gender.MALE));
        mentors.add(new Mentor("Amy","Bryan",25, Gender.FEMALE));

        model.addAttribute("mentors", mentors);

        return "mentor/mentor";
    }

}
