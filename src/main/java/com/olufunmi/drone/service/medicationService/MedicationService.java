package com.olufunmi.drone.service.medicationService;

import com.olufunmi.drone.dto.request.AddMedicationRequest;
import com.olufunmi.drone.model.Medication;

public interface MedicationService {
    Medication addMedication(AddMedicationRequest request);
}
