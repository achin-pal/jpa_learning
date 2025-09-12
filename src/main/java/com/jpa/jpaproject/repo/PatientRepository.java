package com.jpa.jpaproject.repo;

import com.jpa.jpaproject.entity.Patient;
import com.jpa.jpaproject.entity.type.BloodGroup;
import com.jpa.jpaproject.repo.entity.BloodGroupCountRepoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByBirthDate(LocalDate localDate);

    @Query("Select p FROM Patient p where p.bloodGroup = ?1 ")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroup bg);


    @Query("select p FROM Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate bd);

//    @Query("select p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();

    @Query("select new com.jpa.jpaproject.repo.entity.BloodGroupCountRepoEntity(p.bloodGroup," +
            " Count(p)) from Patient p group by p.bloodGroup")
    List<BloodGroupCountRepoEntity> countEachBloodGroupType();

    @Query(value = "select * from patient" , nativeQuery = true)
    List<Patient> findAllPatients();


    @Query(value = "select * from patient" , nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int upDateUserNameWithId(@Param("name") String name , @Param("id") Long id);
}
