package asherflo.com.drone.service;

import asherflo.com.drone.dto.request.AddMedicationRequest;
import asherflo.com.drone.model.Medication;

public interface MedicationService {
    Medication addMedication(AddMedicationRequest request);
}
