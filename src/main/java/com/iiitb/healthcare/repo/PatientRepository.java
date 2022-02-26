package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PatientRepository extends JpaRepository<PatientEntity,Integer> {

    @Query(value="SELECT * FROM patient P INNER JOIN userpermissionpatient UPP ON P.Id = UPP.PatientId WHERE UPP.UserId = ?1 AND UPP.CanView=1",nativeQuery = true)
    public List<PatientEntity> findAllPatientByUser(long id);

}
