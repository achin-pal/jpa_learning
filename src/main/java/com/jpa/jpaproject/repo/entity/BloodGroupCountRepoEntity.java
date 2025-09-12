package com.jpa.jpaproject.repo.entity;

import com.jpa.jpaproject.entity.type.BloodGroup;

public class BloodGroupCountRepoEntity {

    private BloodGroup bloodGroup;

    public BloodGroupCountRepoEntity(BloodGroup bloodGroup, Long count) {
        this.bloodGroup = bloodGroup;
        this.count = count;
    }

    private Long count;


}
