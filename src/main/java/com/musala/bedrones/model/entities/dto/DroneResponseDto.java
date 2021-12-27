package com.musala.bedrones.model.entities.dto;

import com.musala.bedrones.model.entities.enums.DroneModel;
import com.musala.bedrones.model.entities.enums.DroneState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DroneResponseDto {
    private String id;
    private String serialNo;
    private DroneModel model;
    private int weight;
    private int batteryCapacity;
    private DroneState droneState;
}
