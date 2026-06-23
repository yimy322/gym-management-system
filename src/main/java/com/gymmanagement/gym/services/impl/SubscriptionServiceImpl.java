package com.gymmanagement.gym.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.gymmanagement.gym.entities.Member;
import com.gymmanagement.gym.entities.Membership;
import com.gymmanagement.gym.entities.Subscription;
import com.gymmanagement.gym.repository.MemberRepository;
import com.gymmanagement.gym.repository.MembershipRepository;
import com.gymmanagement.gym.repository.SubscriptionRepository;
import com.gymmanagement.gym.services.SubscriptionService;
import com.gymmanagement.gym.utils.SubscriptionStatus;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final MemberRepository memberRepository;
    private final MembershipRepository membershipRepository;

    public SubscriptionServiceImpl(
            SubscriptionRepository subscriptionRepository,
            MemberRepository memberRepository,
            MembershipRepository membershipRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.memberRepository = memberRepository;
        this.membershipRepository = membershipRepository;
    }

    @Override
    public Subscription assignMembership(Long memberId, Long membershipId) {
        // Buscar el afiliado por su identificador
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Afiliado no encontrado"));
        // Buscar la membresía seleccionada
        Membership membership = membershipRepository.findById(membershipId)
                .orElseThrow(() -> new RuntimeException("Membresía no encontrada"));
        // Verificar que el afiliado no tenga una membresía activa
        if (subscriptionRepository
                .findByMemberAndStatus(member, SubscriptionStatus.ACTIVE)
                .isPresent()) {

            throw new RuntimeException(
                    "El afiliado ya cuenta con una membresía activa");
        }
        // Calcular fechas de inicio y vencimiento
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(membership.getDurationMonths());

        // Crear la nueva suscripción
        Subscription subscription = new Subscription();
        subscription.setMember(member);
        subscription.setMembership(membership);
        subscription.setStartDate(startDate);
        subscription.setEndDate(endDate);
        subscription.setStatus(SubscriptionStatus.ACTIVE);

        // Persistir la suscripción en la base de datos
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    /**
     * Tarea programada que se ejecuta diariamente para identificar
     * suscripciones vencidas y actualizar su estado.
     */
    @Override
    @Scheduled(cron = "0 0 0 * * *")
    public void updateExpiredSubscriptions() {
    
        List<Subscription> activeSubscriptions = subscriptionRepository.findByStatus(SubscriptionStatus.ACTIVE);

        LocalDate today = LocalDate.now();

        for (Subscription subscription : activeSubscriptions) {
            if (subscription.getEndDate().isBefore(today)) {
                subscription.setStatus(SubscriptionStatus.INACTIVE);
                subscriptionRepository.save(subscription);
            }
        }
    }
}
