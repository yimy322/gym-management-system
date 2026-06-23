package com.gymmanagement.gym.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gymmanagement.gym.entities.Membership;
import com.gymmanagement.gym.repository.MembershipRepository;
import com.gymmanagement.gym.services.impl.MembershipsServiceImpl;
import com.gymmanagement.gym.utils.SubscriptionStatus;

@ExtendWith(MockitoExtension.class)
public class MembershipsServiceTest {

    @Mock
    private MembershipRepository repository;

    @InjectMocks
    private MembershipsServiceImpl membershipsServiceImpl;

    private Membership membership;

    @BeforeEach
    void setUp() {
        membership = new Membership();
        membership.setId(1L);
        membership.setName("Plan Basico");
        membership.setDurationMonths(1);
        membership.setPrice(new BigDecimal("300.00"));
        membership.setStatus(SubscriptionStatus.ACTIVE);
    }

    //FIND ALL
    @Test
    void findAll_shouldReturnAllMemberships() {
        when(repository.findAll()).thenReturn(List.of(membership));
        List<Membership> result = membershipsServiceImpl.findAll();
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void findAll_whenNoMemberships_shouldReturnEmptyList() {
        when(repository.findAll()).thenReturn(List.of());
        List<Membership> result = membershipsServiceImpl.findAll();
        assertTrue(result.isEmpty());
        verify(repository, times(1)).findAll();
    }

    //CREATE
    @Test
    void save_shouldSaveMembershipAndReturnIt() {
        when(repository.save(membership)).thenReturn(membership);
        Membership result = membershipsServiceImpl.save(membership);
        assertNotNull(result);
        assertEquals("Plan Basico", result.getName());
        assertEquals(new BigDecimal("300.00"), result.getPrice());
        verify(repository, times(1)).save(membership);
    }

    //READ BY ID
    @Test
    void findById_whenExists_shouldReturnMembership() {
        when(repository.findById(1L)).thenReturn(Optional.of(membership));
        Membership result = membershipsServiceImpl.findById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Plan Basico", result.getName());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void findById_whenNotFound_shouldReturnNull() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        Membership result = membershipsServiceImpl.findById(99L);
        assertNull(result);//el servicio hace orElse(null)
        verify(repository, times(1)).findById(99L);
    }

    //DELETE
    @Test
    void delete_shouldCallRepositoryDeleteById() {
        doNothing().when(repository).deleteById(1L);
        membershipsServiceImpl.delete(1L);
        verify(repository, times(1)).deleteById(1L);
    }

}
