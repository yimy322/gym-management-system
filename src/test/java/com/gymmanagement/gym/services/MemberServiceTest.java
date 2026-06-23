package com.gymmanagement.gym.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gymmanagement.gym.entities.Member;
import com.gymmanagement.gym.repository.MemberRepository;
import com.gymmanagement.gym.services.impl.MemberServiceImpl;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberServiceImpl memberService;

    private Member member;

    @BeforeEach
    void setUp() {
        member = new Member();
        member.setId(1L);
        member.setFirstName("Juan");
        member.setLastName("Perez");
        member.setDni("12345678");
    }

    //CREATE
    @Test
    void save_shouldSaveMember() {
        when(memberRepository.save(member)).thenReturn(member);
        Member result = memberService.save(member);
        assertNotNull(result);
        assertEquals(member.getId(), result.getId());
        verify(memberRepository, times(1)).save(member);
    }

    //READ ALL
    @Test
    void findAll_shouldReturnMemberList() {
        when(memberRepository.findAll()).thenReturn(List.of(member));
        List<Member> result = memberService.findAll();
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(memberRepository, times(1)).findAll();
    }

    //READ BY ID
    @Test
    void findById_whenMemberExists_shouldReturnMember() {
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        Optional<Member> result = memberService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("Juan", result.get().getFirstName());
    }

    //UPDATE
    @Test
    void update_shouldUpdateMemberData() {
        Member data = new Member();
        data.setFirstName("Juan Editado");
        data.setLastName("Perez");
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(memberRepository.save(any(Member.class))).thenReturn(data);
        Member result = memberService.update(1L, data);
        assertEquals("Juan Editado", result.getFirstName());
        verify(memberRepository, times(1)).save(any(Member.class));
    }

    //DELETE
    @Test
    void delete_shouldDeleteMember() {
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        memberService.delete(1L);
        verify(memberRepository, times(1)).findById(1L);
        verify(memberRepository, times(1)).delete(member);
    }

}