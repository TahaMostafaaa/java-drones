package com.drones.drones.task.exceptions;

import com.drones.drones.task.constants.ErrorMessages;

public class DroneBatteryLow extends Exception {

    public DroneBatteryLow() {
        super(ErrorMessages.DRONE_BATTERY_LOW);
    }

    public DroneBatteryLow(String message) {
        super(message);
    }
}
