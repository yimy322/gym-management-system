package com.gymmanagement.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/memberships")
public class MembershipController {

    @GetMapping
    public String list() {
        return "memberships/list";
    }

    @GetMapping("/settings")
    public String settings() {
        return "memberships/settings";
    }

}
