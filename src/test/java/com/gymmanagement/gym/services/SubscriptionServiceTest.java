package com.gymmanagement.gym.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gymmanagement.gym.entities.Member;
import com.gymmanagement.gym.entities.Membership;
import com.gymmanagement.gym.entities.Subscription;
import com.gymmanagement.gym.repository.MemberRepository;
import com.gymmanagement.gym.repository.MembershipRepository;
import com.gymmanagement.gym.repository.SubscriptionRepository;
import com.gymmanagement.gym.services.impl.SubscriptionServiceImpl;
import com.gymmanagement.gym.utils.SubscriptionStatus;

@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceTest {

    @Mock
    private SubscriptionRepository subscriptionRepository;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private MembershipRepository membershipRepository;

    @InjectMocks
    private SubscriptionServiceImpl subscriptionServiceImpl;

    private Member member;
    private Membership membership;
    private Subscription subscription;

    @BeforeEach
    void setUp() {
        member = new Member();
        member.setId(1L);
        member.setFirstName("Juan");
        membership = new Membership();
        membership.setId(1L);
        membership.setName("Plan Basico");
        membership.setDurationMonths(1);
        subscription = new Subscription();
        subscription.setId(1L);
        subscription.setMember(member);
        subscription.setMembership(membership);
        subscription.setStartDate(LocalDate.now());
        subscription.setEndDate(LocalDate.now().plusMonths(1));
        subscription.setStatus(SubscriptionStatus.ACTIVE);
    }

    @Test
    void assignMembership_whenValidData_shouldSaveSubscription() {
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(membershipRepository.findById(1L)).thenReturn(Optional.of(membership));
        when(subscriptionRepository.findByMemberAndStatus(member, SubscriptionStatus.ACTIVE))
                .thenReturn(Optional.empty());
        when(subscriptionRepository.save(any(Subscription.class))).thenReturn(subscription);
        Subscription result = subscriptionServiceImpl.assignMembership(1L, 1L);
        assertNotNull(result);
        assertEquals(SubscriptionStatus.ACTIVE, result.getStatus());
        verify(subscriptionRepository, times(1)).save(any(Subscription.class));
    }

    @Test
    void assignMembership_whenMemberNotFound_shouldThrowException() {
        when(memberRepository.findById(99L)).thenReturn(Optional.empty());
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                subscriptionServiceImpl.assignMembership(99L, 1L));
        assertEquals("Afiliado no encontrado", ex.getMessage());
        verify(subscriptionRepository, never()).save(any());
    }

    @Test
    void assignMembership_whenAlreadyHasActiveMembership_shouldThrowException() {
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(membershipRepository.findById(1L)).thenReturn(Optional.of(membership));
        when(subscriptionRepository.findByMemberAndStatus(member, SubscriptionStatus.ACTIVE))
                .thenReturn(Optional.of(subscription)); //ya tiene una activa
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                subscriptionServiceImpl.assignMembership(1L, 1L));
        assertEquals("El afiliado ya cuenta con una membresía activa", ex.getMessage());
        verify(subscriptionRepository, never()).save(any());
    }

    @Test
    void updateExpiredSubscriptions_whenSubscriptionExpired_shouldSetInactive() {
        subscription.setEndDate(LocalDate.now().minusDays(1)); //vencio ayer
        subscription.setStatus(SubscriptionStatus.ACTIVE);
        when(subscriptionRepository.findByStatus(SubscriptionStatus.ACTIVE))
                .thenReturn(List.of(subscription));
        subscriptionServiceImpl.updateExpiredSubscriptions();
        assertEquals(SubscriptionStatus.INACTIVE, subscription.getStatus());
        verify(subscriptionRepository, times(1)).save(subscription);
    }

    //READ ALL
    @Test
    void findAll_shouldReturnAllSubscriptions() {
        when(subscriptionRepository.findAll()).thenReturn(List.of(subscription));
        List<Subscription> result = subscriptionServiceImpl.findAll();
        assertFalse(result.isEmpty());
        verify(subscriptionRepository, times(1)).findAll();
    }

}
