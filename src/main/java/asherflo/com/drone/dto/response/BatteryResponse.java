package asherflo.com.drone.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Setter
public class BatteryResponse {
    private String batteryLevel;
    private Long droneId;
    private String droneModel;
    private String serialNumber;
}
