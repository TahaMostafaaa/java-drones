package com.drones.drones.task.exceptions;

import com.drones.drones.task.constants.ErrorMessages;

public class DroneLimitWeightExceeded extends Exception {

    public DroneLimitWeightExceeded() {
        super(ErrorMessages.DRONE_LIMIT_WEIGHT_EXCEEDED);
    }

    public DroneLimitWeightExceeded(String message) {
        super(message);
    }
}
