package com.olufunmi.drone.dto.response;

import com.olufunmi.drone.model.Medication;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoadDroneResponse {
    private String message;
    private Medication medication;


}
