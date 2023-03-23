package asherflo.com.drone.service;

import asherflo.com.drone.dto.request.AddMedicationRequest;
import asherflo.com.drone.model.Medication;
import asherflo.com.drone.repository.MedicationRepository;
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
