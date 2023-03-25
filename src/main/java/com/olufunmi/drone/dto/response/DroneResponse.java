package com.olufunmi.drone.dto.response;

import com.olufunmi.drone.model.Medication;
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
    private double batteryLevel;
private String droneState;

    private List<Medication> medications ;
}
