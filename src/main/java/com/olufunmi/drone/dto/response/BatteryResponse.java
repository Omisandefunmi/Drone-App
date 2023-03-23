package com.olufunmi.drone.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Setter
public class BatteryResponse {
    private String batteryLevel;
    private String serialNumber;
    private String droneModel;

}
