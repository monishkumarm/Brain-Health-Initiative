package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepo extends JpaRepository<OrganizationEntity,Long> {
    List<OrganizationEntity> findAll();
}
