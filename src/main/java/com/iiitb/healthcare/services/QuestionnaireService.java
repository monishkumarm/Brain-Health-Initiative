package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.entities.QuestionnaireEntity;
import com.iiitb.healthcare.model.entities.QuestionnaireOptionEntity;
import com.iiitb.healthcare.repo.QuestionnaireOptionRepository;
import com.iiitb.healthcare.repo.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionnaireOptionRepository questionnaireOptionRepository;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository,QuestionnaireOptionRepository questionnaireOptionRepository) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionnaireOptionRepository =questionnaireOptionRepository;
    }

    public List<QuestionnaireEntity> getCommonQuestions(){
        List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(1);

        return questions;
    }
    public List<QuestionnaireEntity> getNextQuestions(Map<String,Object> payload){
        List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(1);
        List<Long> answer = new ArrayList<>();
        Map<String,Object> map = (Map)(payload.get("commanQuestionnary"));

        for(String s : map.keySet()){
            answer.add((long)((int)map.get(s)));
        }

        List<QuestionnaireOptionEntity> options = questionnaireOptionRepository.options(answer);


        boolean arr[]= new boolean [answer.size()];
        for(int i=0;i<arr.length;i++){
            String a = options.get(i).getOption();
            if(a.equals("Yes"))arr[options.get(i).getQuestionId().intValue()-1]=true;
            else arr[options.get(i).getQuestionId().intValue()-1]=false;
        }

        if((arr[0]&arr[1]&arr[2])){

            List<QuestionnaireEntity> nextQue = questionnaireRepository.findByGroupAndSubGroupId(2,1);
            return nextQue;
        }
        else if((arr[3]&arr[4]&arr[5]&arr[6]&arr[7])){

            List<QuestionnaireEntity> nextQue = questionnaireRepository.findByGroupAndSubGroupId(3,1);
            return nextQue;
        }
        return questions;
    }
}
