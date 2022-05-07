package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PatientRepository extends JpaRepository<PatientEntity,Integer> {

    @Query(value="select * from (SELECT * FROM Patient P INNER JOIN UserPermissionPatient UPP ON P.Id = UPP.PatientId WHERE UPP.UserId = ?1 AND UPP.CanView=1) `PU*`",nativeQuery = true)
    List<PatientEntity> findAllPatientByUser(long id);

    List<PatientEntity> findById(long id);

    List<PatientEntity> findByAbhaId(String abhaId);

    List<PatientEntity> findByFirstName(String firstName);

    List<PatientEntity> findByPhoneNumber(String phoneNumber);
}
