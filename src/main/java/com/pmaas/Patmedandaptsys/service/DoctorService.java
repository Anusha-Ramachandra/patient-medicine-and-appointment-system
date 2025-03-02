package com.pmaas.Patmedandaptsys.service;

import com.pmaas.Patmedandaptsys.entity.Doctor;
import com.pmaas.Patmedandaptsys.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Fetch all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}

