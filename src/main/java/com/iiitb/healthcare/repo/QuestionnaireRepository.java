package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.QuestionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionnaireRepository extends JpaRepository<QuestionnaireEntity, Integer> {

    List<QuestionnaireEntity> findByGroupId(Integer groupId);
}
