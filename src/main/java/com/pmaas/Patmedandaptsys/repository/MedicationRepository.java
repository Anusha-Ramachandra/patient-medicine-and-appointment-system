package com.pmaas.Patmedandaptsys.repository;

import com.pmaas.Patmedandaptsys.entity.Medication;
import com.pmaas.Patmedandaptsys.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
    List<Medication> findByPatient(Patient patient);
}

