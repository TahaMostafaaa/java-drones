package com.drones.drones.task.services.impl;

import com.drones.drones.task.repositories.DroneRepository;
import com.drones.drones.task.repositories.MedicationRepository;
import com.drones.drones.task.constants.enums.State;
import com.drones.drones.task.dtos.DroneDTO;
import com.drones.drones.task.dtos.MedicationDTO;
import com.drones.drones.task.entities.Drone;
import com.drones.drones.task.entities.Medication;
import com.drones.drones.task.exceptions.DroneBatteryLow;
import com.drones.drones.task.exceptions.DroneBlockLoading;
import com.drones.drones.task.exceptions.DroneLimitWeightExceeded;
import com.drones.drones.task.exceptions.DroneNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.drones.drones.task.services.DroneService;

@Service
public class DroneServiceImpl implements DroneService {

    @Autowired
    public DroneRepository droneRepository;

    @Autowired
    private MedicationRepository medicationRepository;


    @Override
    @Transactional
    public DroneDTO registerDrone(DroneDTO newDrone){
        Drone droneEntity = new Drone(
                newDrone.getSerialNumber(),
                newDrone.getModel(),
                newDrone.getWeightLimit(),
                newDrone.getBatteryCapacity(),
                State.IDLE);
        droneRepository.save(droneEntity);
        newDrone.setState(State.IDLE);
        return newDrone;
    }

    @Override
    @Transactional
    public MedicationDTO loadMedicationToDrone(String serialNumber, MedicationDTO medicationDTO) throws DroneNotFound, DroneBatteryLow, DroneBlockLoading, DroneLimitWeightExceeded  {
        Drone drone = validateDroneLoading(serialNumber, medicationDTO);
        if(drone.getState().equals(State.IDLE)){
            drone.setState(State.LOADING);
            droneRepository.save(drone);
        }

        Medication medication = new Medication(
                medicationDTO.getName(),
                medicationDTO.getWeight(),
                medicationDTO.getCode(),
                medicationDTO.getImage());
        medication.setDrone(drone);
        medicationRepository.save(medication);
        medicationDTO.setDrone(DroneDTO.builder()
                    .serialNumber(drone.getSerialNumber())
                    .model(drone.getModel())
                    .weightLimit(drone.getWeightLimit())
                    .state(drone.getState())
                    .batteryCapacity(drone.getBatteryCapacity())
                    .medications(this.mapMedicationToMedicationDTO(drone.getMedications()))
                    .build());
        return medicationDTO;
    }

    private Drone validateDroneLoading(String serialNumber, MedicationDTO medicationDTO) throws DroneNotFound, DroneBatteryLow, DroneBlockLoading, DroneLimitWeightExceeded {
        Optional<Drone> optionalDrone = droneRepository.findBySerialNumber(serialNumber);
        if(!optionalDrone.isPresent()){
            throw new DroneNotFound();
        }
        Drone drone = optionalDrone.get();
        if(!drone.getState().equals(State.IDLE) && !drone.getState().equals(State.LOADING)){
            throw new DroneBlockLoading();
        }
        if(drone.getBatteryCapacity() < 25){
            throw new DroneBatteryLow();
        }
        List<Medication> medications = this.getMedicationsByDroneId(optionalDrone.get().getId());

        int totalWeight = medications.stream().mapToInt( medication -> medication.getWeight()).sum();

        if(totalWeight + medicationDTO.getWeight() > drone.getWeightLimit()){
            throw new DroneLimitWeightExceeded();
        }
        return drone;
    }

    private List<Medication> getMedicationsByDroneId(long id) {
        return medicationRepository.findByDrone_Id(id);
    }

    @Override
    public List<DroneDTO> getAllAvailableDrones() {
        List<Drone> idleDrones = droneRepository.findByState(State.IDLE);
        List<DroneDTO> results = new ArrayList<>();
        idleDrones.forEach(drone -> results.add(DroneDTO.builder()
                            .serialNumber(drone.getSerialNumber())
                            .model(drone.getModel())
                            .weightLimit(drone.getWeightLimit())
                            .state(drone.getState())
                            .batteryCapacity(drone.getBatteryCapacity())
                            .medications(this.mapMedicationToMedicationDTO(drone.getMedications()))
                            .build()));
        return results;
    }


    private List<MedicationDTO> mapMedicationToMedicationDTO(List<Medication> medications){

        List<MedicationDTO> medicationDtos = new ArrayList<>();
        medications.forEach( medication -> 
                            medicationDtos.add(MedicationDTO.builder()
                            .name(medication.getName())
                            .code(medication.getCode())
                            .weight(medication.getWeight())
                            .image(medication.getImage())
                            .build()));
        return medicationDtos;

    }

    @Override
    public DroneDTO getDroneBySerialNumber(String serialNumber) throws DroneNotFound {
        Optional<Drone> droneOptional = droneRepository.findBySerialNumber(serialNumber);
        if(!droneOptional.isPresent())
        {
            throw new DroneNotFound();
        }
        Drone drone = droneOptional.get();

        DroneDTO droneDTO = DroneDTO.builder()
                            .serialNumber(drone.getSerialNumber())
                            .model(drone.getModel())
                            .weightLimit(drone.getWeightLimit())
                            .weightLimit(drone.getWeightLimit())
                            .state(State.IDLE)
                            .batteryCapacity(drone.getBatteryCapacity())
                            .medications(this.mapMedicationToMedicationDTO(drone.getMedications()))
                            .build();
        return droneDTO;
    }
}
