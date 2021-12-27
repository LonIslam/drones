package com.musala.bedrones.model.entities.dto;

import com.musala.bedrones.model.entities.enums.DroneModel;
import com.musala.bedrones.model.entities.enums.DroneState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DroneDto {
    @Size(min = 1, max = 100)
    private String serialNo;
    @NotBlank
    private DroneModel model;
    @Max(value = 500)
    private int weight;
    @Min(value = 0)
    @Max(value = 100)
    private int batteryCapacity;
    @NotBlank
    private DroneState droneState;
}
