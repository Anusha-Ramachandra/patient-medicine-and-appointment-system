package com.pmaas.Patmedandaptsys.controller;

import com.pmaas.Patmedandaptsys.entity.Patient;
import com.pmaas.Patmedandaptsys.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // ✅ Allow frontend access
@RestController
@RequestMapping("/api/patients") // ✅ Updated base path to match Vite proxy
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // ✅ 1️⃣ Register a new patient
    @PostMapping
    public Patient registerPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    // ✅ 2️⃣ Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // ✅ 3️⃣ Get a patient by ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    // ✅ 4️⃣ Update patient details
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        return patientRepository.findById(id).map(patient -> {
            patient.setName(updatedPatient.getName());
            patient.setContact(updatedPatient.getContact());
            patient.setMedicalHistory(updatedPatient.getMedicalHistory());
            return patientRepository.save(patient);
        }).orElse(null);
    }

    // ✅ 5️⃣ Delete a patient
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
        return "Patient deleted successfully!";
    }
}
