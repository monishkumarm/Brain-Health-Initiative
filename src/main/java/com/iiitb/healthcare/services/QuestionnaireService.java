package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.entities.QuestionnaireEntity;
import com.iiitb.healthcare.repo.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    public List<QuestionnaireEntity> getCommonQuestions(){
        List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(1);

        return questions;
    }
}
