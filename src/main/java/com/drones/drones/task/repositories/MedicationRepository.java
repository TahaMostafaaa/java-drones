package com.drones.drones.task.repositories;

import com.drones.drones.task.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
        List<Medication> findByDrone_Id(long id);
}
