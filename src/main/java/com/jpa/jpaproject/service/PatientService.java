package com.jpa.jpaproject.service;

import com.jpa.jpaproject.entity.Patient;
import com.jpa.jpaproject.repo.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){
        Patient patient = patientRepository.findById(id).orElseThrow();

        Patient patient1 = patientRepository.findById(id).orElseThrow();

        return  patient;
    }
}
