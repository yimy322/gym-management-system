package com.gymmanagement.gym.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gymmanagement.gym.entities.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

    boolean existsByDni(String dni);

    Long countByStatusTrue();

    List<Member> findByDniContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String dni,
            String firstName,
            String lastName
    );

}
