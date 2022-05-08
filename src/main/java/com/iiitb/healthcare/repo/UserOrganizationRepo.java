package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.UserOrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserOrganizationRepo extends JpaRepository<UserOrganizationEntity,Long> {

}
