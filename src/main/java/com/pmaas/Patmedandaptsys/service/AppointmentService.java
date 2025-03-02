package com.pmaas.Patmedandaptsys.service;

import com.pmaas.Patmedandaptsys.entity.Appointment;
import com.pmaas.Patmedandaptsys.entity.Patient;
import com.pmaas.Patmedandaptsys.repository.AppointmentRepository;
import com.pmaas.Patmedandaptsys.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    // 1. Fetch all available appointments
    public List<Appointment> getAvailableAppointments() {
        return appointmentRepository.findByIsBookedFalse();
    }

    // 2. Book an appointment for a patient
    public boolean bookAppointment(Long appointmentId, Long patientId) {
        Optional<Appointment> appointmentOpt = appointmentRepository.findById(appointmentId);
        Optional<Patient> patientOpt = patientRepository.findById(patientId);

        if (appointmentOpt.isPresent() && patientOpt.isPresent()) {
            Appointment appointment = appointmentOpt.get();
            Patient patient = patientOpt.get();

            if (!appointment.isBooked()) {
                appointment.setBooked(true);
                appointment.setPatient(patient);
                appointmentRepository.save(appointment);
                return true;
            }
        }
        return false;
    }

    // 3. Get all appointments for a patient
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}

