package com.musala.bedrones.service;

import com.musala.bedrones.model.entities.DroneBasket;
import com.musala.bedrones.model.entities.Medication;
import com.musala.bedrones.model.entities.dto.DronePackageDto;
import com.musala.bedrones.model.entities.dto.DroneResponseDto;
import com.musala.bedrones.model.entities.dto.MedicationResponseDto;
import com.musala.bedrones.model.repo.DronesBasketRepository;
import com.musala.bedrones.model.repo.DronesRepository;
import com.musala.bedrones.model.repo.MedicationsRepository;
import com.musala.bedrones.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DroneLoadingService {

    private DronesRepository dronesRepository;
    private DronesBasketRepository dronesBasketRepository;
    private MedicationsRepository medicationsRepository;

    @Autowired
    public DroneLoadingService(DronesRepository dronesRepository,
                               DronesBasketRepository dronesBasketRepository,
                               MedicationsRepository medicationsRepository) {
        this.dronesRepository = dronesRepository;
        this.dronesBasketRepository = dronesBasketRepository;
        this.medicationsRepository = medicationsRepository;
    }

    public ResponseEntity<DroneResponseDto> loadDrone(DronePackageDto dronePackageDto) {
        return null;
    }

    public ResponseEntity<List<MedicationResponseDto>> getLoadedMedication(String id) {
        Optional<DroneBasket> optionalDroneBasket = dronesBasketRepository.findByDroneId(id);
        if (optionalDroneBasket.isPresent()) {
            List<Medication> medications = new ArrayList<>();

            medicationsRepository.findAllById(optionalDroneBasket.get().getMedicationsIds()).forEach(medications::add);
            List<MedicationResponseDto> medicationResponseDtos = medications.stream().map(medication -> Util.getModelMapper().map(medication, MedicationResponseDto.class)).collect(Collectors.toList());
            return ResponseEntity.ok(medicationResponseDtos);
        } else
            return ResponseEntity.notFound().build();
    }
}
