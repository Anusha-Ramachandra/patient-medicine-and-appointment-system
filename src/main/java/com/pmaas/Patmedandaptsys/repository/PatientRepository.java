package com.pmaas.Patmedandaptsys.repository;

import com.pmaas.Patmedandaptsys.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Find a patient by contact number (assuming it's unique)
    Optional<Patient> findByContact(String contact);

    // Find patients by name (may return multiple results)
    List<Patient> findByNameContainingIgnoreCase(String name);
}
