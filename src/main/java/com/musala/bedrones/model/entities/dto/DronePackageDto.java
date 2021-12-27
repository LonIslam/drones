package com.musala.bedrones.model.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DronePackageDto {
    private List<String> medicationsIds;
    private String droneId;
}
