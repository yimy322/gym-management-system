package com.gymmanagement.gym.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymmanagement.gym.entities.Attendance;
import com.gymmanagement.gym.entities.Member;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

    List<Attendance> findByMemberOrderByAttendanceDateDesc(Member member);

    Optional<Attendance> findByMemberAndAttendanceDate(Member member, LocalDate attendanceDate);
}
