package net.javaguides.__backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.__backend.dto.ScheduleDto;
import net.javaguides.__backend.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private ScheduleService scheduleService;

    // Build add Schedule REST API
    @PostMapping
    public ResponseEntity<ScheduleDto> createSchedule(@RequestBody ScheduleDto scheduleDto) {
        ScheduleDto savedSchedule = scheduleService.createSchedule(scheduleDto);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    // Build get Schedule by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<ScheduleDto> getScheduleById(@PathVariable("id") Long scheduleId) {
        ScheduleDto scheduleDto = scheduleService.getScheduleById(scheduleId);
        return ResponseEntity.ok(scheduleDto);
    }

    // Get all Schedules REST API
    @GetMapping
    public ResponseEntity<List<ScheduleDto>> getAllSchedules() {
        List<ScheduleDto> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    // Delete Schedule by ID REST API
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable("id") Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.noContent().build();
    }

    // Update Schedule by ID REST API
    @PutMapping("{id}")
    public ResponseEntity<ScheduleDto> updateSchedule(@PathVariable("id") Long scheduleId,
                                                      @RequestBody ScheduleDto updatedSchedule) {
        ScheduleDto scheduleDto = scheduleService.updateSchedule(scheduleId, updatedSchedule);
        return ResponseEntity.ok(scheduleDto);
    }
}
