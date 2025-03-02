package com.pmaas.Patmedandaptsys.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medications", indexes = {
        @Index(name = "idx_medication_name", columnList = "name")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String dosage;

    @Column(nullable = false, length = 255)
    private String instructions;

    // If medications belong to a patient
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
}
