package com.drones.drones.task.exceptions;

import com.drones.drones.task.constants.ErrorMessages;

public class DroneNotFound extends Exception {

    public DroneNotFound() {
        super(ErrorMessages.DRONE_NOT_FOUND);
    }

    public DroneNotFound(String message) {
        super(message);
    }
}
