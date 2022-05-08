package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.PatientConsultationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<PatientConsultationEntity, Integer> {

    List<PatientConsultationEntity> getAllByPatientIdOrderByReferredOnDesc(long patientId);

    @Query(value="SELECT COUNT(*) FROM patientconsultation",nativeQuery = true)
    public long getConsultationCount();
    PatientConsultationEntity getById(long id);
}
