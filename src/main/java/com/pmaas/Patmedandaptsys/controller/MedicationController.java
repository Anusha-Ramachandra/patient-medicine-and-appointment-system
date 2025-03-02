package com.pmaas.Patmedandaptsys.controller;

import com.pmaas.Patmedandaptsys.entity.Medication;
import com.pmaas.Patmedandaptsys.service.MedicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    // 1. Fetch all medications for a patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Medication>> getMedications(@PathVariable Long patientId) {
        return ResponseEntity.ok(medicationService.getMedicationsByPatientId(patientId));
    }

    // 2. Add medication
    @PostMapping("/patient/{patientId}/add")
    public ResponseEntity<Medication> addMedication(@PathVariable Long patientId, @RequestBody Medication medication) {
        return ResponseEntity.ok(medicationService.addMedication(medication, patientId));
    }


    // 3. Delete medication
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMedication(@PathVariable Long id) {
        medicationService.deleteMedication(id);
        return ResponseEntity.ok("Medication removed successfully!");
    }
}

