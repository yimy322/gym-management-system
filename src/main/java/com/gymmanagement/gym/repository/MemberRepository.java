package com.gymmanagement.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymmanagement.gym.entities.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

    boolean existsByDni(String dni);

}
