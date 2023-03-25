package com.olufunmi.drone.dto.request;

import com.olufunmi.drone.model.enums.DroneModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DroneRegistrationRequest {
    private  String serialNumber;
    private DroneModel droneModel;
    private double batteryLevel;
    private String message;

}
