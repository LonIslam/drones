package com.musala.bedrones.model.repo;

import com.musala.bedrones.model.entities.DroneBatteryHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DronesBatteryHistoryRepository extends MongoRepository<DroneBatteryHistory, String> {
}
