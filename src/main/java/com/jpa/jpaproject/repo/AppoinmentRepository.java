package com.jpa.jpaproject.repo;

import com.jpa.jpaproject.entity.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppoinmentRepository extends JpaRepository<Appoinment, Long> {
}