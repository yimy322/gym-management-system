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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gymmanagement.gym.entities.Attendance;
import com.gymmanagement.gym.entities.Member;
import com.gymmanagement.gym.repository.AttendanceRepository;
import com.gymmanagement.gym.repository.MemberRepository;
import com.gymmanagement.gym.services.impl.AttendanceServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AttendanceServiceTest {

    @Mock
    private AttendanceRepository attendanceRepository;

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private AttendanceServiceImpl attendanceServiceImpl;

    private Member member;
    private Attendance attendance;

    @BeforeEach
    void setUp() {
        member = new Member();
        member.setId(1L);
        member.setFirstName("Juan");
        member.setLastName("Perez");

        attendance = new Attendance();
        attendance.setId(1L);
        attendance.setMember(member);
        attendance.setAttendanceDate(LocalDate.now());
        attendance.setCheckInTime(LocalDateTime.now());
    }

    //CREATE
    @Test
    void registerAttendance_whenMemberExistsAndNotRegisteredToday_shouldSaveAttendance() {
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(attendanceRepository.findByMemberAndAttendanceDate(member, LocalDate.now()))
                .thenReturn(Optional.empty());
        when(attendanceRepository.save(any(Attendance.class))).thenReturn(attendance);
        Attendance result = attendanceServiceImpl.registerAttendance(1L);
        assertNotNull(result);
        assertEquals(member, result.getMember());
        verify(attendanceRepository, times(1)).save(any(Attendance.class));
    }

    //CREATE
    @Test
    void registerAttendance_whenMemberNotFound_shouldThrowException() {
        when(memberRepository.findById(99L)).thenReturn(Optional.empty());
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                attendanceServiceImpl.registerAttendance(99L));
        assertEquals("Afiliado no encontrado", ex.getMessage());
        verify(attendanceRepository, never()).save(any());
    }

    //CREATE
    @Test
    void registerAttendance_whenMemberAlreadyRegisteredToday_shouldThrowException() {
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(attendanceRepository.findByMemberAndAttendanceDate(member, LocalDate.now()))
                .thenReturn(Optional.of(attendance));
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                attendanceServiceImpl.registerAttendance(1L));
        assertEquals("El afiliado ya registró asistencia el día de hoy", ex.getMessage());
        verify(attendanceRepository, never()).save(any());
    }

    //FIND
    @Test
    void findHistoryByMember_whenMemberExists_shouldReturnHistory() {
        List<Attendance> history = List.of(attendance);
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(attendanceRepository.findByMemberOrderByAttendanceDateDesc(member))
                .thenReturn(history);
        List<Attendance> result = attendanceServiceImpl.findHistoryByMember(1L);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(attendanceRepository, times(1))
                .findByMemberOrderByAttendanceDateDesc(member);
    }

    @Test
    void findHistoryByMember_whenMemberNotFound_shouldThrowException() {
        when(memberRepository.findById(99L)).thenReturn(Optional.empty());
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                attendanceServiceImpl.findHistoryByMember(99L));
        assertEquals("Afiliado no encontrado", ex.getMessage());
        verify(attendanceRepository, never())
                .findByMemberOrderByAttendanceDateDesc(any());
    }

    //READ ALL
    @Test
    void findAll_shouldReturnAllAttendances() {
        when(attendanceRepository.findAll()).thenReturn(List.of(attendance));
        List<Attendance> result = attendanceServiceImpl.findAll();
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(attendanceRepository, times(1)).findAll();
    }

}
