package com.gymmanagement.gym.controllers;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gymmanagement.gym.services.MemberService;
import com.gymmanagement.gym.services.PaymentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final PaymentService paymentService;
    private final MemberService memberService;

    @GetMapping("/dashboard")
    public String index(Model model) {
        BigDecimal totalIncome = paymentService.getTotalAmount();
        model.addAttribute("activePage", "dashboard");
        model.addAttribute("totalIncome", totalIncome);
        model.addAttribute("countActiveMembers", memberService.countByStatusTrue());
        return "dashboard";
    }

}
