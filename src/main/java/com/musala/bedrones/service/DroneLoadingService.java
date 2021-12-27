package com.musala.bedrones.service;

import com.musala.bedrones.model.entities.Drone;
import com.musala.bedrones.model.entities.DroneBasket;
import com.musala.bedrones.model.entities.Medication;
import com.musala.bedrones.model.entities.dto.DronePackageDto;
import com.musala.bedrones.model.entities.dto.DroneResponseDto;
import com.musala.bedrones.model.entities.dto.MedicationResponseDto;
import com.musala.bedrones.model.entities.enums.DroneState;
import com.musala.bedrones.model.repo.DronesBasketRepository;
import com.musala.bedrones.model.repo.DronesRepository;
import com.musala.bedrones.model.repo.MedicationsRepository;
import com.musala.bedrones.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        Optional<Drone> droneOptional = dronesRepository.findById(dronePackageDto.getDroneId());
        if (droneOptional.isPresent() && droneOptional.get().getDroneState().equals(DroneState.IDLE)
                && droneOptional.get().getBatteryCapacity() >= 25) {
            List<Medication> medications = new ArrayList<>();
            medicationsRepository.findAllById(dronePackageDto.getMedicationsIds()).forEach(medications::add);
            int sum = medications.stream().map(Medication::getWeight).mapToInt(Integer::intValue).sum();
            if (sum <= droneOptional.get().getWeight()) {
                DroneBasket droneBasket = new DroneBasket();
                droneBasket.setDroneId(dronePackageDto.getDroneId());
                droneBasket.setMedicationsIds(dronePackageDto.getMedicationsIds());
                dronesBasketRepository.save(droneBasket);
                droneOptional.get().setDroneState(DroneState.LOADING);
                dronesRepository.save(droneOptional.get());

                return ResponseEntity.ok(Util.getModelMapper().map(droneOptional.get(), DroneResponseDto.class));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
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
