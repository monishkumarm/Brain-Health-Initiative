package com.iiitb.healthcare.controller;

import com.iiitb.healthcare.model.entities.QuestionnaireEntity;
import com.iiitb.healthcare.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @RequestMapping("/getCommonQuestions")
    public ResponseEntity<?> getCommonQuestions(){
        System.out.println("int get common question controller");
        Map<String,Object> questions = questionnaireService.getCommonQuestions();

        return ResponseEntity.ok(questions);
    }

    @RequestMapping(value = "/getNextQuestions",method = RequestMethod.POST)
    public ResponseEntity<?> getNextQuestions(@RequestBody Map<String,Object> payload){

        System.out.println("int get next question controller");
        System.out.println(payload.toString());
        Map<String,Object> questions = questionnaireService.getNextQuestions(payload);

        return ResponseEntity.ok(questions);
    }
}
