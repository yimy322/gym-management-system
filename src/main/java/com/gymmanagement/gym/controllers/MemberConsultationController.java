package com.gymmanagement.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/memberconsultation")
public class MemberConsultationController {

    @GetMapping
    public String Consultademiembros() {
        return "members/consultationmember";
    }

}
