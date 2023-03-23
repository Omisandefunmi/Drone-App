package asherflo.com.drone.dto.response;

import asherflo.com.drone.model.Drone;
import lombok.Data;

@Data
public class DroneResponse {
    private String message;
    private Drone drone;
}
