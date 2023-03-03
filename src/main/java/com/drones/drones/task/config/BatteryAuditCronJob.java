package com.drones.drones.task.config;

import com.drones.drones.task.entities.Drone;
import com.drones.drones.task.entities.DronesBatteryAudit;
import com.drones.drones.task.repositories.DronesBatteryAuditRepository;
import com.drones.drones.task.repositories.DroneRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.EnableAsync;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@EnableAsync
public class BatteryAuditCronJob {

    private static final Logger log = LoggerFactory.getLogger(BatteryAuditCronJob.class);

    @Autowired
    private  DroneRepository droneRepository;
    
    @Autowired
    private  DronesBatteryAuditRepository dronesBatteryAuditRepository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 20000)
    public void auditDroneBattery() {
        log.info("Audting Drones at {}", dateFormat.format(new Date()));
            Iterable<Drone> all = droneRepository.findAll();
            List<DronesBatteryAudit> droneBatteryAuditList = new ArrayList<>();
            all.forEach(drone -> droneBatteryAuditList.add(new DronesBatteryAudit(drone)));
            dronesBatteryAuditRepository.saveAll(droneBatteryAuditList);

    }
}
