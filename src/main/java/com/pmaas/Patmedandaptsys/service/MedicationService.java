package com.pmaas.Patmedandaptsys.service;

import com.pmaas.Patmedandaptsys.entity.Medication;
import com.pmaas.Patmedandaptsys.entity.Patient;
import com.pmaas.Patmedandaptsys.repository.MedicationRepository;
import com.pmaas.Patmedandaptsys.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicationService {
    private final MedicationRepository medicationRepository;
    private final PatientRepository patientRepository;

    public MedicationService(MedicationRepository medicationRepository, PatientRepository patientRepository) {
        this.medicationRepository = medicationRepository;
        this.patientRepository = patientRepository;
    }

    // Fetch all medications for a patient
    public List<Medication> getMedicationsByPatientId(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return medicationRepository.findByPatient(patient);
    }

    // Add medication
    public Medication addMedication(Medication medication, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        medication.setPatient(patient);
        return medicationRepository.save(medication);
    }

    // Delete medication
    public void deleteMedication(Long id) {
        medicationRepository.deleteById(id);
    }
}
