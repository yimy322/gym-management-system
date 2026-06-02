package com.gymmanagement.gym.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gymmanagement.gym.entities.Attendance;
import com.gymmanagement.gym.entities.Member;
import com.gymmanagement.gym.repository.AttendanceRepository;
import com.gymmanagement.gym.repository.MemberRepository;
import com.gymmanagement.gym.services.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final MemberRepository memberRepository;

    public AttendanceServiceImpl(
            AttendanceRepository attendanceRepository,
            MemberRepository memberRepository) {
        this.attendanceRepository = attendanceRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public Attendance registerAttendance(Long memberId) {

        // Buscar el afiliado por su identificador
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Afiliado no encontrado"));

        LocalDate today = LocalDate.now();

        // Validar que el afiliado no registre asistencia dos veces el mismo día
        if (attendanceRepository
                .findByMemberAndAttendanceDate(member, today)
                .isPresent()) {

            throw new RuntimeException("El afiliado ya registró asistencia el día de hoy");
        }

        // Crear el registro de asistencia
        Attendance attendance = new Attendance();
        attendance.setMember(member);
        attendance.setAttendanceDate(today);
        attendance.setCheckInTime(LocalDateTime.now());

        // Guardar la asistencia en la base de datos
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> findHistoryByMember(Long memberId) {

        // Buscar el afiliado para consultar su historial
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Afiliado no encontrado"));

        return attendanceRepository.findByMemberOrderByAttendanceDateDesc(member);
    }

    @Override
    public List<Attendance> findAll() {
        return attendanceRepository.findAll();
    }
}
