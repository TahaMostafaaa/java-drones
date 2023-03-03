package com.drones.drones.task.exceptions;


import com.drones.drones.task.constants.ErrorMessages;

public class DroneBlockLoading extends Exception {

    public DroneBlockLoading() {
        super(ErrorMessages.DRONE_BLOCKED_LOADING);
    }

    public DroneBlockLoading(String message) {
        super(message);
    }
}
