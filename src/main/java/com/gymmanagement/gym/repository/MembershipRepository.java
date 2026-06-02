package com.gymmanagement.gym.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymmanagement.gym.entities.Membership;

@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long> {

    Optional<Membership> findByName(String name);
}
