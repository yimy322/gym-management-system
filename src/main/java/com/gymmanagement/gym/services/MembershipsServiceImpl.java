package com.gymmanagement.gym.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymmanagement.gym.entities.Memberships;
import com.gymmanagement.gym.repository.MembershipsRepository;

import lombok.RequiredArgsConstructor;

//@Service
@RequiredArgsConstructor
public class MembershipsServiceImpl implements MembershipsService {

    private final MembershipsRepository repository;

    @Override
    public List<Memberships> listar() {
        return repository.findAll();
    }

    @Override
    public Memberships guardar(Memberships membresia) {
        return repository.save(membresia);
    }

    @Override
    public Memberships buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
