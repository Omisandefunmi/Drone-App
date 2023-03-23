package asherflo.com.drone.dto.response;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
@AllArgsConstructor
public class MedicationResponse {
    private String name;
    private double weight;

    private String code;
    private String image;
}
