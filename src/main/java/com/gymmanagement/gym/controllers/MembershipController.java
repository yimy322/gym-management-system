package com.gymmanagement.gym.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gymmanagement.gym.entities.Membership;
import com.gymmanagement.gym.services.MembershipsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/memberships")
@RequiredArgsConstructor
public class MembershipController {

    @GetMapping("/settings")
    public String settings() {
        return "memberships/settings";
    }

    // private final MembershipsService service;

    // LISTAR + FORMULARIO
    @GetMapping
    public String list(Model model) {

        // model.addAttribute("memberships", service.listar());

        // model.addAttribute("membership", new Memberships());

        return "memberships/list";
    }

    // GUARDAR O ACTUALIZAR
    @PostMapping("/save")
    public String save(@ModelAttribute Membership membership) {

        // service.guardar(membership);

        return "redirect:/memberships";
    }

    // EDITAR (CARGAR FORMULARIO)
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        // model.addAttribute("membership", service.buscarPorId(id));
        // model.addAttribute("memberships", service.listar());

        return "memberships/list";
    }

    // ELIMINAR
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        // service.eliminar(id);

        return "redirect:/memberships";
    }
}
