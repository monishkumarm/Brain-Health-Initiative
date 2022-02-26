package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.UserPermissionPatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionPatientEntityRepository extends JpaRepository<UserPermissionPatientEntity, Long> {

}
