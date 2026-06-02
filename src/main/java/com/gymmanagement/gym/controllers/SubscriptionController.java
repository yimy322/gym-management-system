package com.gymmanagement.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gymmanagement.gym.repository.MemberRepository;
import com.gymmanagement.gym.repository.MembershipRepository;
import com.gymmanagement.gym.services.SubscriptionService;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final MemberRepository memberRepository;
    private final MembershipRepository membershipRepository;

    public SubscriptionController(SubscriptionService subscriptionService, MemberRepository memberRepository,
            MembershipRepository membershipRepository) {
        this.subscriptionService = subscriptionService;
        this.memberRepository = memberRepository;
        this.membershipRepository = membershipRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("subscriptions", subscriptionService.findAll());
        return "subscriptions/list";
    }

    @GetMapping("/new")
    public String showAssignForm(Model model) {
        model.addAttribute("members", memberRepository.findAll());
        model.addAttribute("memberships", membershipRepository.findAll());
        return "subscriptions/form";
    }

    @PostMapping("/assign")
    public String assignMembership(@RequestParam Long memberId,
            @RequestParam Long membershipId) {
        subscriptionService.assignMembership(memberId, membershipId);
        return "redirect:/subscriptions";
    }

}
