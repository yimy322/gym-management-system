package com.gymmanagement.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gymmanagement.gym.entities.Member;
import com.gymmanagement.gym.services.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("afiliados", memberService.findAll());
        model.addAttribute("activePage", "members");
        return "members/list";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("members", memberService.findAll());
        model.addAttribute("member", new Member());
        model.addAttribute("activePage", "membersRegistration");
        return "members/register";
    }

    @PostMapping("/register")
    public String save(@Valid @ModelAttribute Member member,
                   BindingResult result,
                   Model model) {
        if(result.hasErrors()) {
            model.addAttribute("activePage", "membersRegistration");
            return "members/register";
        }
        if(member.getId() != null) {
            Member current = memberService.findById(member.getId()).orElseThrow();
            //seteamos el original por si acaso
            member.setDni(current.getDni());
        }
        if(member.getId() == null) {
            memberService.save(member);
        } else {
            memberService.update(member.getId(), member);
        }
        return "redirect:/members/register";//para volver a lamisma pantalla
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Member member = memberService.findById(id).orElseThrow();//si existe si o si por eso no validamos el optional
        model.addAttribute("member", member);
        model.addAttribute("members", memberService.findAll());
        model.addAttribute("activePage", "membersRegistration");
        return "members/register";
    }

    @GetMapping("/toggle-status/{id}")
    public String toggleStatus(@PathVariable Long id) {
        memberService.toggleStatus(id);
        return "redirect:/members/register";
    }

}
