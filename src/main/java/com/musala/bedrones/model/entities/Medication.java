package com.musala.bedrones.model.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@Document(collection = "Medications")
public class Medication {
    @Id
    private String id;
    @Pattern(regexp = "[A-Za-z0-9_-]")
    private String name;
    private int weight;
    @Pattern(regexp = "[A-Z0-9_]")
    private String code;
    private String image;

    @CreatedDate
    private LocalDateTime creationTimestamp;
    @LastModifiedDate
    private LocalDateTime lastModified;

}
