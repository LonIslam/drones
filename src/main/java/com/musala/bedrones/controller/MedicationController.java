package com.musala.bedrones.controller;

import com.musala.bedrones.model.entities.dto.MedicationDto;
import com.musala.bedrones.model.entities.dto.MedicationResponseDto;
import com.musala.bedrones.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/medications", produces = APPLICATION_JSON_VALUE)
public class MedicationController {

    private final MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping("/")
    public ResponseEntity<MedicationResponseDto> registerDrone(@Valid @RequestBody MedicationDto medicationDto) {
        return medicationService.createMedication(medicationDto);
    }
}