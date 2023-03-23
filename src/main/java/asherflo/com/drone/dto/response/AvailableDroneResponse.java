package asherflo.com.drone.dto.response;

import asherflo.com.drone.model.Drone;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDroneResponse {
    private  String status;
    private List<Drone>drones;
}
