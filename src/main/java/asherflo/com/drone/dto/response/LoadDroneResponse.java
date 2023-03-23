package asherflo.com.drone.dto.response;

import asherflo.com.drone.model.Drone;
import asherflo.com.drone.model.Medication;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoadDroneResponse {
    private String message;
    private Medication medication;


}
