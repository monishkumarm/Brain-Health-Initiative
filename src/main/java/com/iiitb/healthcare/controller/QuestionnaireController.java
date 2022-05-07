package com.iiitb.healthcare.controller;

import com.iiitb.healthcare.services.QuestionnaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        System.out.println("in get next question controller");
        System.out.println(payload.toString());
        Map<String,Object> questions = questionnaireService.getNextQuestions(payload);

        return ResponseEntity.ok(questions);
    }

    @RequestMapping(value = "/saveAnswers",method = RequestMethod.POST)
    public  ResponseEntity<?> saveAnswers(@RequestBody Map<String,Object> payload[]){
        System.out.println("in save answers controller");
        for (Map<String, Object> map : payload) {
            System.out.println(map.toString());
        }
//        System.out.println(payload.toString());
        String res = "Answers save";
        return ResponseEntity.ok(res);
    }
}
