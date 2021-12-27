package com.musala.bedrones.controller;

import com.musala.bedrones.model.entities.dto.DroneDto;
import com.musala.bedrones.model.entities.dto.DroneResponseDto;
import com.musala.bedrones.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/drone", produces = APPLICATION_JSON_VALUE)
public class DroneController {

    private final DroneService droneService;

    @Autowired
    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @PostMapping("/")
    public ResponseEntity<DroneResponseDto> registerDrone(@Valid @RequestBody DroneDto droneDto) {
        return droneService.registerDrone(droneDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Integer> getDroneBatteryLevel(@PathVariable("id") String id) {
        return droneService.getDroneBatteryLevel(id);
    }

    @GetMapping("/available")
    public ResponseEntity<List<DroneResponseDto>> getAvailableDrones() {
        return droneService.getAvailableDrones();
    }
}