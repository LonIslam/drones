package com.musala.bedrones.model.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicationResponseDto {
    private String id;
    private String name;
    private int weight;
    private String code;
    private String image;

    @CreatedDate
    private LocalDateTime creationTimestamp;
    @LastModifiedDate
    private LocalDateTime lastModified;

}
