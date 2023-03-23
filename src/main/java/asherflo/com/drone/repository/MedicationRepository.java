package asherflo.com.drone.repository;

import asherflo.com.drone.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication,Long> {


}
