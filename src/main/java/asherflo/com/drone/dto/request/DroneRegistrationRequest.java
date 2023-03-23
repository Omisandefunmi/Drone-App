package asherflo.com.drone.dto.request;

import asherflo.com.drone.model.enums.DroneModel;
import asherflo.com.drone.model.enums.DroneState;
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

    private String batteryCapacity;
    private DroneState droneState;
    private String message;

}
