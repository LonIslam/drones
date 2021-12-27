package com.musala.bedrones.service;

import com.musala.bedrones.model.entities.Drone;
import com.musala.bedrones.model.entities.dto.DroneDto;
import com.musala.bedrones.model.entities.dto.DroneResponseDto;
import com.musala.bedrones.model.entities.enums.DroneState;
import com.musala.bedrones.model.repo.DronesRepository;
import com.musala.bedrones.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DroneService {

    private DronesRepository dronesRepository;

    @Autowired
    public DroneService(DronesRepository dronesRepository) {
        this.dronesRepository = dronesRepository;
    }

    public ResponseEntity<DroneResponseDto> registerDrone(DroneDto droneDto) {
        Drone droneEntity = Util.getModelMapper().map(droneDto, Drone.class);
        dronesRepository.save(droneEntity);
        return ResponseEntity.accepted().body(Util.getModelMapper().map(droneEntity, DroneResponseDto.class));
    }

    public ResponseEntity<List<DroneResponseDto>> getAvailableDrones() {
        List<Drone> availableDrones = dronesRepository.findByDroneState(DroneState.IDLE);
        List<DroneResponseDto> droneResponseDtos = availableDrones.stream().map(drone -> Util.getModelMapper().map(drone, DroneResponseDto.class)).collect(Collectors.toList());
        return ResponseEntity.accepted().body(droneResponseDtos);
    }

    public ResponseEntity<Integer> getDroneBatteryLevel(String id) {
        Optional<Drone> droneOptional = dronesRepository.findById(id);
        return droneOptional.map(drone -> ResponseEntity.ok(drone.getBatteryCapacity())).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
