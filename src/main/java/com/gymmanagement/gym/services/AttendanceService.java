package com.gymmanagement.gym.services;

import java.util.List;

import com.gymmanagement.gym.entities.Attendance;

public interface AttendanceService {

    Attendance registerAttendance(Long memberId);

    List<Attendance> findHistoryByMember(Long memberId);

    List<Attendance> findAll();
}
