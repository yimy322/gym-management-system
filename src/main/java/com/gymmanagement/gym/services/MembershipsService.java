package com.gymmanagement.gym.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymmanagement.gym.entities.Membership;


@Service
public interface MembershipsService {

    List<Membership> findAll();

    Membership save(Membership membresia);

    Membership findById(Long id);

    void delete(Long id);
}
