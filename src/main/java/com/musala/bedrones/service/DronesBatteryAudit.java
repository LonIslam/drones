package com.musala.bedrones.service;

import com.musala.bedrones.model.entities.Drone;
import com.musala.bedrones.model.entities.DroneBatteryHistory;
import com.musala.bedrones.model.repo.DronesBatteryHistoryRepository;
import com.musala.bedrones.model.repo.DronesRepository;
import com.musala.bedrones.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class DronesBatteryAudit {

    private DronesRepository dronesRepository;
    private DronesBatteryHistoryRepository dronesBatteryHistoryRepository;

    @Autowired
    public DronesBatteryAudit(DronesRepository dronesRepository, DronesBatteryHistoryRepository dronesBatteryHistoryRepository) {
        this.dronesRepository = dronesRepository;
        this.dronesBatteryHistoryRepository = dronesBatteryHistoryRepository;
    }


    @Scheduled(cron = "0 * * * *")
    public void checkDronesBatteryLevels() {
        List<Drone> droneList = dronesRepository.findAll();
        List<DroneBatteryHistory> droneBatteryHistories = droneList.stream().map(drone -> Util.getModelMapper().map(drone, DroneBatteryHistory.class)).collect(Collectors.toList());
        dronesBatteryHistoryRepository.saveAll(droneBatteryHistories);
    }
}
