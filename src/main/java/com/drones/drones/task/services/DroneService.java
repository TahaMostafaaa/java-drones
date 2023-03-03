package com.drones.drones.task.services;

import com.drones.drones.task.dtos.DroneDTO;
import com.drones.drones.task.dtos.MedicationDTO;
import com.drones.drones.task.exceptions.DroneBatteryLow;
import com.drones.drones.task.exceptions.DroneBlockLoading;
import com.drones.drones.task.exceptions.DroneLimitWeightExceeded;
import com.drones.drones.task.exceptions.DroneNotFound;

import java.util.List;

public interface DroneService {

    DroneDTO registerDrone(DroneDTO newDrone);

    List<DroneDTO> getAllAvailableDrones();

    MedicationDTO loadMedicationToDrone(String serialNumber, MedicationDTO medicationDTO) throws DroneNotFound, DroneBatteryLow, DroneBlockLoading, DroneLimitWeightExceeded;

    DroneDTO getDroneBySerialNumber(String serialNumber) throws DroneNotFound;
}
