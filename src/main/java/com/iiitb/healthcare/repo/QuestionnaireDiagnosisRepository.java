package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.QuestionnaireDiagnosisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireDiagnosisRepository extends JpaRepository<QuestionnaireDiagnosisEntity, Long> {

    QuestionnaireDiagnosisEntity getById(Long id);

}
