package com.musala.bedrones.controller;

import com.musala.bedrones.model.entities.dto.DroneDto;
import com.musala.bedrones.model.entities.dto.DronePackageDto;
import com.musala.bedrones.model.entities.dto.DroneResponseDto;
import com.musala.bedrones.model.entities.dto.MedicationResponseDto;
import com.musala.bedrones.service.DroneLoadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/drone-load", produces = APPLICATION_JSON_VALUE)
public class DroneLoadController {

    private final DroneLoadingService droneLoadingService;

    @Autowired
    public DroneLoadController(DroneLoadingService droneLoadingService) {
        this.droneLoadingService = droneLoadingService;
    }

    @PostMapping("/")
    public ResponseEntity<DroneResponseDto> LoadDrone(@Valid @RequestBody DronePackageDto dronePackageDto) {
        return droneLoadingService.loadDrone(dronePackageDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<MedicationResponseDto>> getLoadedMedication(@PathVariable("id") String id) {
        return droneLoadingService.getLoadedMedication(id);
    }
}