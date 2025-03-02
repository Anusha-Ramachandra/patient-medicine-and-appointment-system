package com.pmaas.Patmedandaptsys.repository;

import com.pmaas.Patmedandaptsys.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Find all appointments for a specific patient
    List<Appointment> findByPatientId(Long patientId);

    // Find all appointments for a given date
    List<Appointment> findByDate(LocalDate date);

    // Find upcoming appointments
    List<Appointment> findByDateAfter(LocalDate today);

    List<Appointment> findByIsBookedFalse();
}
