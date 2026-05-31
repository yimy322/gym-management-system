package com.gymmanagement.gym.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymmanagement.gym.entities.Memberships;


@Service
public interface MembershipsService {

    List<Memberships> listar();

    Memberships guardar(Memberships membresia);

    Memberships buscarPorId(Long id);

    void eliminar(Long id);
}
