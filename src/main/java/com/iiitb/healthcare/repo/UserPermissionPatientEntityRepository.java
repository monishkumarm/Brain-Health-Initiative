package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.UserPermissionPatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserPermissionPatientEntityRepository extends JpaRepository<UserPermissionPatientEntity, Long> {

    @Query(value = "SELECT * FROM UserPermissionPatient UPP  WHERE UPP.UserId = ?1 AND UPP.PatientId=?2", nativeQuery = true)
    UserPermissionPatientEntity getPatientByUser(long userId, long patientId);


}
