package com.olufunmi.drone.repository;

import com.olufunmi.drone.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication,Long> {


}
