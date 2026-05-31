package com.gymmanagement.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymmanagement.gym.entities.Memberships;


public interface MembershipsRepository extends JpaRepository<Memberships,Long> {

}
