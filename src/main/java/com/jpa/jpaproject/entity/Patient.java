package com.jpa.jpaproject.entity;

import com.jpa.jpaproject.entity.type.BloodGroup;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_emaill", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthdatee", columnNames = {"name","birthDate"})
        },
        indexes = {
                @Index(name = "idx_patient_birth_datee" , columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String email;
    private String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;



    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", blood_group='" + bloodGroup + '\'' +
                '}';
    }


}
