package com.jpa.jpaproject.repo;

import com.jpa.jpaproject.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}