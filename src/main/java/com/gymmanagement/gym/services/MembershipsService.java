package com.gymmanagement.gym.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymmanagement.gym.entities.Membership;


@Service
public interface MembershipsService {

    List<Membership> listar();

    Membership guardar(Membership membresia);

    Membership buscarPorId(Long id);

    void eliminar(Long id);
}
