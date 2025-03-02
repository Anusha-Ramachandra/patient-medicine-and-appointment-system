package com.pmaas.Patmedandaptsys.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PatientDto {
    private Long id;
    private String Name;
    private String Contact;
    private String MedicalHistory;
}



