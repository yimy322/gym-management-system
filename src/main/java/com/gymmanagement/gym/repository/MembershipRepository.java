package com.gymmanagement.gym.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gymmanagement.gym.entities.Membership;

public interface MembershipRepository extends JpaRepository<Membership,Long> {

    Optional<Membership> findByName(String name);
}
