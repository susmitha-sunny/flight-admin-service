package com.gotravel.flightadminservice.service;

import com.gotravel.flightadminservice.entity.Schedule;
import com.gotravel.flightadminservice.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule addSchedule(final Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
}
