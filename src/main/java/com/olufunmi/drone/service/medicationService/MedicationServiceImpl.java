package com.olufunmi.drone.service.medicationService;

import com.olufunmi.drone.dto.request.AddMedicationRequest;
import com.olufunmi.drone.model.Medication;
import com.olufunmi.drone.repository.MedicationRepository;
import com.olufunmi.drone.service.medicationService.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepository medicationRepository;

    @Override
    public Medication addMedication(AddMedicationRequest request) {

        Medication medication = Medication.builder()
                .image(request.getImageUrl())
                .code(request.getCode())
                .weight(request.getWeight())
                .name(request.getName())
                .build();
        medicationRepository.save(medication);
        return medication;
    }
}
