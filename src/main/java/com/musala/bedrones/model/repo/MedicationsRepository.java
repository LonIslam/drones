package com.musala.bedrones.model.repo;

import com.musala.bedrones.model.entities.Drone;
import com.musala.bedrones.model.entities.Medication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationsRepository extends MongoRepository<Medication, String> {
}
