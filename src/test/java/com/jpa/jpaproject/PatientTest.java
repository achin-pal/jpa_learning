package com.jpa.jpaproject;

import com.jpa.jpaproject.entity.Patient;
import com.jpa.jpaproject.entity.type.BloodGroup;
import com.jpa.jpaproject.repo.PatientRepository;
import com.jpa.jpaproject.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatenitRepo(){

        List<Patient> list = patientRepository.findAll();
        List<Patient> data = patientRepository.findByBirthDate(LocalDate.of(1988,3,15));
        System.out.println(list);
    }

    @Test
    public void testPatenitRepofromService(){

//        Patient p =  patientService.getPatientById(1L);
//        List<Patient> list = patientRepository.findByBloodGroup(BloodGroup.A_POSITIVE);
//        List<Patient> list = patientRepository.findByBornAfterDate(LocalDate.of(1993,3,15));
//        System.out.println(list);


//        List<Object[]> list = patientRepository.countEachBloodGroupType();
//
//        for (Object [] objects : list){
//            System.out.println(objects[0] + "  " +objects[1]);
//        }


//        int updatedRows = patientRepository.upDateUserNameWithId("SRK", 1L);
//        System.out.println(updatedRows);

        Page<Patient> list = patientRepository.findAllPatients(PageRequest.of(1,2));

    }
}
