package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.PatientQuestionnaireAnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientQuestionnaireAnswerRepository extends JpaRepository<PatientQuestionnaireAnswerEntity,Long> {
}
