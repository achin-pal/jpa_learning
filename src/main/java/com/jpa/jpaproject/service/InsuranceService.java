package com.jpa.jpaproject.service;


import com.jpa.jpaproject.entity.Insurance;
import com.jpa.jpaproject.entity.Patient;
import com.jpa.jpaproject.repo.InsuranceRepository;
import com.jpa.jpaproject.repo.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
      Patient  patient= patientRepository.findById(patientId)
                .orElseThrow(()->new EntityNotFoundException("patient not found "+patientId));
      patient.setInsurance(insurance);  // only this will create a insurance also next line is not needed
        // this is bec patient is directy as it is modifuied
      insurance.setPatient(patient);  // bidirectional consistency

      return patient;
    }
}
