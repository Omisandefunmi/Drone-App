package com.olufunmi.drone.dto.response;

import com.olufunmi.drone.model.Drone;
import com.olufunmi.drone.model.Medication;
import com.olufunmi.drone.model.enums.DroneModel;
import com.olufunmi.drone.model.enums.DroneState;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class DroneResponse {
    private  String serialNumber;

    private String droneModel;
    private  double weightLimit;

    private double loadedWeight;
    private String batteryCapacity;
    private String droneState;

    private List<Medication> medications ;
}
