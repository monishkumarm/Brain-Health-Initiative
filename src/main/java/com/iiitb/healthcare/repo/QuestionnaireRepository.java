package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.PatientQuestionnaireAnswerEntity;
import com.iiitb.healthcare.model.entities.QuestionnaireEntity;
import com.iiitb.healthcare.model.entities.QuestionnaireOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public interface QuestionnaireRepository extends JpaRepository<QuestionnaireEntity, Integer> {

    List<QuestionnaireEntity> findByGroupId(Integer groupId);

    @Query(value="SELECT * FROM Questionnaire WHERE GroupId =?1 AND SubGroupId=?2",nativeQuery = true)
    List<QuestionnaireEntity> findByGroupAndSubGroupId(Integer gid, Integer subGid);


}
