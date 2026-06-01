package com.gymmanagement.gym.services;

import java.util.List;
import com.gymmanagement.gym.entities.Subscription;

public interface SubscriptionService {

    Subscription assignMembership(Long memberId, Long membershipId);

    List<Subscription> findAll();

    void updateExpiredSubscriptions();
}
