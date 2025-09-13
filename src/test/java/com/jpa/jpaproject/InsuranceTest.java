package com.jpa.jpaproject;


import com.jpa.jpaproject.entity.Appoinment;
import com.jpa.jpaproject.entity.Insurance;
import com.jpa.jpaproject.entity.Patient;
import com.jpa.jpaproject.service.AppointmentService;
import com.jpa.jpaproject.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testIncurnace(){
        Insurance insurance = Insurance.builder()
                .policyNumber("1234HDFC")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient= insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);

    }

//    @Test
//    public void testCreateAppointment() {
//        Appoinment appointment = Appoinment.builder()
//                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
//                .reason("Fever")
//                .build();
//
//        var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);
//
////        System.out.println(newAppointment);
//
////        var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);
//
//        System.out.println(newAppointment);
//    }
}
