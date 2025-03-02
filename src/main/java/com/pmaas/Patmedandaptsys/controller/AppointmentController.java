package com.pmaas.Patmedandaptsys.controller;

import com.pmaas.Patmedandaptsys.entity.Appointment;
import com.pmaas.Patmedandaptsys.service.AppointmentService;
import com.pmaas.Patmedandaptsys.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;

    public AppointmentController(AppointmentService appointmentService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }

    // 1. Fetch available appointments
    @GetMapping("/available")
    public ResponseEntity<List<Appointment>> getAvailableAppointments() {
        return ResponseEntity.ok(appointmentService.getAvailableAppointments());
    }

    // 2. Book an appointment
    @PostMapping("/book/{appointmentId}/patient/{patientId}")
    public ResponseEntity<String> bookAppointment(@PathVariable Long appointmentId, @PathVariable Long patientId) {
        boolean success = appointmentService.bookAppointment(appointmentId, patientId);
        return success ? ResponseEntity.ok("Appointment booked successfully!") : ResponseEntity.badRequest().body("Failed to book appointment.");
    }

    // 3. Get all appointments for a patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getPatientAppointments(@PathVariable Long patientId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatientId(patientId));
    }
}

