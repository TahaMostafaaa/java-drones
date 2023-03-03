package com.drones.drones.task.controllers;

import com.drones.drones.task.dtos.DroneDTO;
import com.drones.drones.task.dtos.MedicationDTO;
import com.drones.drones.task.services.DroneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/drones")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @GetMapping(value="/{serialNumber}", produces = "application/json")
    public ResponseEntity<DroneDTO> getDrone(@PathVariable String serialNumber) throws Exception {
        return ResponseEntity.ok(droneService.getDroneBySerialNumber(serialNumber));
    }

    @PostMapping(value={"", "/"}, consumes = "application/json")
    public ResponseEntity<DroneDTO> registerDrone(@Valid @RequestBody DroneDTO droneDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(droneService.registerDrone(droneDTO));
    }

    @PutMapping(value = "load-medication/{serialNumber}", consumes = "application/json")
    public ResponseEntity<MedicationDTO> loadDrone(@PathVariable String serialNumber, @Valid @RequestBody MedicationDTO medicationDTO) throws Exception {
        return ResponseEntity.ok(droneService.loadMedicationToDrone(serialNumber, medicationDTO));
    }

    @GetMapping(value="/available-drones", produces = "application/json")
    public ResponseEntity<List<DroneDTO>> availableDrones() {
        return ResponseEntity.ok(droneService.getAllAvailableDrones());
    }

}
