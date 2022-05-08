package com.iiitb.healthcare.controller;

import com.iiitb.healthcare.model.CustomUserDetails;
import com.iiitb.healthcare.model.entities.PatientQuestionnaireEntity;
import com.iiitb.healthcare.services.QuestionnaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        Map<String,Object> questions = questionnaireService.getCommonQuestions();
        return ResponseEntity.ok(questions);
    }

    @RequestMapping(value = "/getNextQuestions",method = RequestMethod.POST)
    public ResponseEntity<?> getNextQuestions(@RequestBody Map<String,Object> payload){

        Map<String,Object> questions = questionnaireService.getNextQuestions(payload);

        return ResponseEntity.ok(questions);
    }

    @RequestMapping(value = "/saveAnswers",method = RequestMethod.POST)
    public  ResponseEntity<?> saveAnswers(@RequestBody Map<String,Object> payload){
        System.out.println("save answers");
        System.out.println(payload.toString());
//        for (Map<String, Object> map : payload) {
//            System.out.println(map.toString());
//        }
        var loggedInUserId = getLoggedInUserId();
        PatientQuestionnaireEntity res = questionnaireService.saveAnswers(payload,loggedInUserId);
        return ResponseEntity.ok(res);
    }
    private Long getLoggedInUserId() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var loggedInUser = (CustomUserDetails) auth.getPrincipal();
        return loggedInUser.getUserId();
    }
}
