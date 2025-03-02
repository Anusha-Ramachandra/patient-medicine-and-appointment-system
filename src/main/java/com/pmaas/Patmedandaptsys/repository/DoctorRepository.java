package com.pmaas.Patmedandaptsys.repository;

import com.pmaas.Patmedandaptsys.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

