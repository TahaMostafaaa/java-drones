package com.drones.drones.task.services.impl;

import com.drones.drones.task.repositories.MedicationRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.drones.task.dtos.MedicationDTO;
import com.drones.drones.task.entities.Medication;
import com.drones.drones.task.repositories.MedicationRepository;
import com.drones.drones.task.services.MedicationService;

@Service
public class MedicationServiceImpl implements MedicationService{

    @Autowired
    private MedicationRepository medicationRepository;


    @Override
    public List<MedicationDTO> getAllMedicationItems(){

        List<Medication> medications = medicationRepository.findAll();

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

}
