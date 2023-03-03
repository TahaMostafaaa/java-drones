package com.drones.drones.task.repositories;

import com.drones.drones.task.constants.enums.State;
import com.drones.drones.task.entities.Drone;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DroneRepository extends JpaRepository<Drone, Long> {
    List<Drone> findByState(State state);
    Optional<Drone> findBySerialNumber(String serialNumber);
}
