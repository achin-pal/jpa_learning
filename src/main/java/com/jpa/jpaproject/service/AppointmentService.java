package com.jpa.jpaproject.service;


import com.jpa.jpaproject.entity.Appoinment;
import com.jpa.jpaproject.entity.Doctor;
import com.jpa.jpaproject.entity.Patient;
import com.jpa.jpaproject.repo.AppoinmentRepository;
import com.jpa.jpaproject.repo.DoctorRepository;
import com.jpa.jpaproject.repo.PatientRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
//@NoArgsConstructor(force = true)
//@AllArgsConstructor
@Builder
public class AppointmentService {

    @Autowired
    private final AppoinmentRepository appoinmentRepository;
    @Autowired
    private final DoctorRepository doctorRepository;
    @Autowired
    private final PatientRepository patientRepository;

    public Appoinment createNewAppointment(Appoinment appoinment , Long doctorId , Long patientId) {
//        Long doctorId = createAppointmentRequestDto.getDoctorId();
//        Long patientId = createAppointmentRequestDto.getPatientId();

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow();
//        Appointment appointment = Appointment.builder()
//                .reason(createAppointmentRequestDto.getReason())
//                .appointmentTime(createAppointmentRequestDto.getAppointmentTime())
//                .build();

        appoinment.setPatient(patient);
        appoinment.setDoctor(doctor);
        patient.getAppointments().add(appoinment); // to maintain bidirectional consistency

        return appoinmentRepository.save(appoinment);
        //modelMapper.map(appointment, AppointmentResponseDto.class);
    }

}
