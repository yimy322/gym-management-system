package com.gymmanagement.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

    @GetMapping
    public String list() {
        return "members/list";
    }

    @GetMapping("/register")
    public String register() {
        return "members/register";
    }

}
