package com.musala.bedrones.service;

import com.musala.bedrones.model.entities.Medication;
import com.musala.bedrones.model.entities.dto.MedicationDto;
import com.musala.bedrones.model.entities.dto.MedicationResponseDto;
import com.musala.bedrones.model.repo.MedicationsRepository;
import com.musala.bedrones.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MedicationService {

    private MedicationsRepository medicationsRepository;

    @Autowired
    public MedicationService(MedicationsRepository medicationsRepository) {
        this.medicationsRepository = medicationsRepository;
    }

    public ResponseEntity<MedicationResponseDto> createMedication(MedicationDto medicationDto) {
        Medication medication = Util.getModelMapper().map(medicationDto, Medication.class);
        medicationsRepository.save(medication);
        return ResponseEntity.accepted().body(Util.getModelMapper().map(medication, MedicationResponseDto.class));
    }
}
