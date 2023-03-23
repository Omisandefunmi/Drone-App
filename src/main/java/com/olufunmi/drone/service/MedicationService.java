package com.olufunmi.drone.service;

import com.olufunmi.drone.dto.request.AddMedicationRequest;
import com.olufunmi.drone.model.Medication;

public interface MedicationService {
    Medication addMedication(AddMedicationRequest request);
}
