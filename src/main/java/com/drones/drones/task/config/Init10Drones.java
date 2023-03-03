package com.drones.drones.task.config;

import com.drones.drones.task.constants.enums.Model;
import com.drones.drones.task.constants.enums.State;
import com.drones.drones.task.entities.Drone;
import com.drones.drones.task.repositories.DroneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import java.util.Random;

@Configuration
public class Init10Drones {

    @Autowired
    private DroneRepository droneRepository;

    @PostConstruct
    private void postConstruct() {
        IntStream.range(1, 100).forEach( num -> 
        droneRepository.save(new Drone("DRONE-" + num, 
        Model.Lightweight, new Random().nextInt(100,500),
        new Random().nextInt(5,100), State.IDLE))
        );
    }
    
}
