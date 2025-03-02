package com.pmaas.Patmedandaptsys.mapper;

import com.pmaas.Patmedandaptsys.dto.PatientDto;
import com.pmaas.Patmedandaptsys.entity.Patient;



public class PatientMapper {
    public static PatientDto mapToPatientDto(Patient patient){
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getContact(),
                patient.getMedicalHistory()
        );
    }
    public static Patient mapToPatient(PatientDto patientDto){
        return new Patient(
                patientDto.getId(),
                patientDto.getName(),
                patientDto.getContact(),
                patientDto.getMedicalHistory()
        );
    }
}
