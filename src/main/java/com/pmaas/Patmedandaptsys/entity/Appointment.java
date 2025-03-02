package com.pmaas.Patmedandaptsys.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments") // Explicit table name
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Ensures date is mandatory
    private LocalDate date;

    @Column(nullable = false) // Ensures time is mandatory
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false) // Ensures valid patient reference
    private Patient patient;

    @Column(nullable = false) // New column for appointment booking status
    private boolean isBooked = false; // Default: false (available)
}
