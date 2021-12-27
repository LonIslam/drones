package com.musala.bedrones.model.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicationDto {
    @Pattern(regexp = "[A-Za-z0-9_-]")
    private String name;
    private int weight;
    @Pattern(regexp = "[A-Z0-9_]")
    private String code;
    private String image;
}
