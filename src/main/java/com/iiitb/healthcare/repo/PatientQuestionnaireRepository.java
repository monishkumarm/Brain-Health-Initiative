package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.PatientQuestionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientQuestionnaireRepository extends JpaRepository<PatientQuestionnaireEntity,Long> {

}
