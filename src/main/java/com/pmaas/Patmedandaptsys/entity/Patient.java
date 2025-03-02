package com.pmaas.Patmedandaptsys.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patients") // Explicitly defining the table name
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Ensures this field cannot be null
    private String name;

    @Column(nullable = false, unique = true) // Ensures contact is unique
    private String contact;

    @Column(length = 1000) // Allows longer medical history
    private String medicalHistory;
}