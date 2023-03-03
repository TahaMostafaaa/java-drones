package com.drones.drones.task.controllers;

import com.drones.drones.task.dtos.MedicationDTO;
import com.drones.drones.task.services.MedicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @GetMapping(value="/medication-items", produces = "application/json")
    public ResponseEntity<List<MedicationDTO>> getAllDroneMedicationItems(){
        return  ResponseEntity.ok(medicationService.getAllMedicationItems());
    }

}
