package com.musala.bedrones.model.repo;

import com.musala.bedrones.model.entities.DroneBasket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DronesBasketRepository extends MongoRepository<DroneBasket, String> {
    Optional<DroneBasket> findByDroneId(String droneId);
}
