package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.entity.Schedule;
import com.gotravel.flightadminservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping(value = "/flight-admin-service/addschedule")
    public Schedule execute(@RequestBody final Schedule schedule) {
            return scheduleService.addSchedule(schedule);
    }
}
