package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.QuestionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionnaireRepository extends JpaRepository<QuestionnaireEntity, Integer> {

    @Query(value = "SELECT * FROM Questionnaire Q WHERE Q.GroupId = ?1 and Q.SubGroupId=?2", nativeQuery = true)
    List<QuestionnaireEntity> findByGroupId(Integer groupId, Integer subGroupId);


}
