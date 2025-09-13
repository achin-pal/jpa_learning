package com.jpa.jpaproject.repo;

import com.jpa.jpaproject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}