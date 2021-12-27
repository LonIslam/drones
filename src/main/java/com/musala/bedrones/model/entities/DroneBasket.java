package com.musala.bedrones.model.entities;

import com.musala.bedrones.model.entities.enums.DroneState;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "drones-baskets")
public class DroneBasket {
    @Id
    private String id;

    private List<String> medicationsIds;
    private String droneId;

    @CreatedDate
    private LocalDateTime creationTimestamp;
    @LastModifiedDate
    private LocalDateTime lastModified;

}
