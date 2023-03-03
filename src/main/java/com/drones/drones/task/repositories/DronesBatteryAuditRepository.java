package com.drones.drones.task.repositories;

import com.drones.drones.task.entities.DronesBatteryAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DronesBatteryAuditRepository extends JpaRepository<DronesBatteryAudit, Long> {
}
