package com.musala.bedrones.model.repo;

import com.musala.bedrones.model.entities.Drone;
import com.musala.bedrones.model.entities.enums.DroneState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DronesRepository extends MongoRepository<Drone, String> {
    List<Drone> findByDroneState(DroneState droneState);

    Optional<Drone> findById(String id);
}
