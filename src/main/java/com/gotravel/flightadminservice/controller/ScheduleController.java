package com.gotravel.flightadminservice.controller;

import com.gotravel.flightadminservice.entity.Schedule;
import com.gotravel.flightadminservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping(value = "/addschedule")
    public Schedule execute(@RequestBody final Schedule schedule) {
            return scheduleService.addSchedule(schedule);
    }

    @CrossOrigin
    @GetMapping(value = "/schedule")
    public List<Schedule> execute() {
        System.out.println("inside schedule admin");
        return scheduleService.getSchedules();
    }
}
