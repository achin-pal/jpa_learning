package com.jpa.jpaproject.repo;

import com.jpa.jpaproject.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}