package com.olufunmi.drone.dto.response;

import com.olufunmi.drone.model.Drone;
import lombok.Data;

@Data
public class DroneResponse {
    private String message;
    private Drone drone;
}
