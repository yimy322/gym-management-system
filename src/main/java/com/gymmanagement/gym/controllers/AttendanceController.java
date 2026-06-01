package com.gymmanagement.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gymmanagement.gym.repository.MemberRepository;
import com.gymmanagement.gym.services.AttendanceService;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final MemberRepository memberRepository;

    public AttendanceController(AttendanceService attendanceService, MemberRepository memberRepository) {
        this.attendanceService = attendanceService;
        this.memberRepository = memberRepository;
    }

    @GetMapping()
    public String list(Model model) {
        model.addAttribute("activePage", "attendance");
        return "attendance";
    }

    @PostMapping("/register")
    public String registerAttendance(
            @RequestParam Long memberId) {

        attendanceService.registerAttendance(memberId);

        return "redirect:/attendances";
    }

    @GetMapping("/new")
    public String showRegisterForm(Model model) {

        // Enviar afiliados disponibles al formulario
        model.addAttribute("members", memberRepository.findAll());

        return "attendances/form";
    }

    @GetMapping("/history/{memberId}")
    public String showHistoryByMember(
            @PathVariable Long memberId,
            Model model) {

        // Enviar historial de asistencia del afiliado seleccionado
        model.addAttribute("attendances", attendanceService.findHistoryByMember(memberId));

        return "attendances/history";
    }

}
