package com.iiitb.healthcare.controller;

import com.iiitb.healthcare.model.entities.QuestionnaireEntity;
import com.iiitb.healthcare.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @RequestMapping("/getCommonQuestions")
    public ResponseEntity<?> getCommonQuestions(){
        List<QuestionnaireEntity> questions = questionnaireService.getCommonQuestions();

        return ResponseEntity.ok(questions);
    }
}
