package com.musala.bedrones.model.entities;

import com.musala.bedrones.model.entities.enums.DroneModel;
import com.musala.bedrones.model.entities.enums.DroneState;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Document(collection = "drones")
public class Drone {
    @Id
    private String id;
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


    @CreatedDate
    private LocalDateTime creationTimestamp;
    @LastModifiedDate
    private LocalDateTime lastModified;

}
