package com.gymmanagement.gym.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gymmanagement.gym.entities.Member;
import com.gymmanagement.gym.entities.Subscription;
import com.gymmanagement.gym.utils.SubscriptionStatus;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    List<Subscription> findByStatus(SubscriptionStatus status);

    Optional<Subscription> findByMemberAndStatus(Member member, SubscriptionStatus status);
}