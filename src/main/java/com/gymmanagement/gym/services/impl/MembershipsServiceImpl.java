package com.gymmanagement.gym.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymmanagement.gym.entities.Membership;
import com.gymmanagement.gym.repository.MembershipRepository;
import com.gymmanagement.gym.services.MembershipsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembershipsServiceImpl implements MembershipsService {

    private final MembershipRepository repository;

    @Override
    public List<Membership> findAll() {
        return repository.findAll();
    }

    @Override
    public Membership save(Membership membresia) {
        return repository.save(membresia);
    }

    @Override
    public Membership findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
