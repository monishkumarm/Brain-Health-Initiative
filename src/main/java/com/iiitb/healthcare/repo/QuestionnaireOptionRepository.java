package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.QuestionnaireEntity;
import com.iiitb.healthcare.model.entities.QuestionnaireOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionnaireOptionRepository extends JpaRepository<QuestionnaireOptionEntity, Integer> {



    @Query(value = "SELECT * FROM QuestionnaireOption QO WHERE QO.Id in ?1" ,nativeQuery=true)
    List<QuestionnaireOptionEntity> options(List<Long> ids);


}
