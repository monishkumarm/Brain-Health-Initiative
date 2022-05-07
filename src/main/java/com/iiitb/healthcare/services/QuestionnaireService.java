package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.entities.QuestionnaireEntity;
import com.iiitb.healthcare.repo.QuestionnaireOptionRepository;
import com.iiitb.healthcare.repo.QuestionnaireRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionnaireOptionRepository questionnaireOptionRepository;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository, QuestionnaireOptionRepository questionnaireOptionRepository) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionnaireOptionRepository = questionnaireOptionRepository;
    }

    public Map<String, Object> getCommonQuestions() {
        List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(1, 1);
        Map<String, Object> res = new HashMap<>();
        res.put("message", "");
        res.put("questionSetName", "commonQuestions");
        res.put("questionSet", questions);
        res.put("groupId", 1);
        res.put("subGroupId", 1);
        return res;
    }

    public Map<String, Object> getNextQuestions(Map<String, Object> payload) {
        Map<String, Object> res = new HashMap<>();
        System.out.println(payload.toString());
        if ((int) payload.get("groupId") == 1) {
            Map<String, Object> answer = (Map) payload.get("questionsAnswers");
            System.out.println(answer.toString());
            if (((int) answer.get("1") == 1 || (int) answer.get("2") == 3) && (int) answer.get("3") == 5) {
                System.out.println("Epilepsy Protocol");
                res = this.epilepsyProtocol(payload);
            } else if ((int) answer.get("4") == 1 || (int) answer.get("5") == 3 || (int) answer.get("6") == 3 || (int) answer.get("7") == 3 || (int) answer.get("8") == 3) {
                System.out.println("Stroke Protocol");
                res = this.strokeProtocol(payload);
            } else {
                res.put("message", "Opps!! Work In progress");
                res.put("questionSetName", null);
                res.put("questionSet", null);
                res.put("groupId", null);
                res.put("subGroupId", null);
            }
        } else if ((int) payload.get("groupId") == 2) {
            System.out.println("Epilepsy Protocol");
            res = this.epilepsyProtocol(payload);
        }
        return res;
    }

    Map<String, Object> epilepsyProtocol(Map<String, Object> payload) {
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> answer = (Map) payload.get("questionsAnswers");

        if ((int) payload.get("groupId") == 1) {
            List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(2, 1);
            res.put("message", "There is chance of epilepsy diagnostic protocol");
            res.put("questionSetName", "epilepsy");
            res.put("questionSet", questions);
            res.put("groupId", 2);
            res.put("subGroupId", 1);

        } else if ((int) payload.get("subGroupId") == 1) {
            System.out.println(answer.toString());
            int yes = 0;
            int trueAns = 34;
            for (Object ans : answer.values()) {
                if ((int) ans == trueAns) {
                    yes = yes + 1;
                }
                trueAns = trueAns + 2;
            }
            if (yes >= 4) {
                List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(2, 2);
                res.put("message", "Epilepsy check");
                res.put("questionSetName", "epilepsy");
                res.put("questionSet", questions);
                res.put("groupId", 2);
                res.put("subGroupId", 2);
            } else if (yes <= 3) {
                List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(2, 3);
                res.put("message", "");
                res.put("questionSetName", "epilepsy");
                res.put("questionSet", questions);
                res.put("groupId", 2);
                res.put("subGroupId", 3);
            } else if (yes < 3) {
                res.put("message", "Uncertain for Seizure");
                res.put("questionSetName", null);
                res.put("questionSet", null);
                res.put("groupId", null);
                res.put("subGroupId", null);
            }
        } else if ((int) payload.get("subGroupId") == 2) {
            if ((int) answer.get("22") == 46) {
                List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(2, 5);
                res.put("message", "Diagnosis in children");
                res.put("questionSetName", "epilepsy");
                res.put("questionSet", questions);
                res.put("groupId", 2);
                res.put("subGroupId", 5);
            } else {
                List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(2, 4);
                res.put("message", "");
                res.put("questionSetName", "epilepsy");
                res.put("questionSet", questions);
                res.put("groupId", 2);
                res.put("subGroupId", 4);
            }

        } else if ((int) payload.get("subGroupId") == 3) {
            if ((int) answer.get("23") == 48 || (int) answer.get("24") == 50 || (int) answer.get("25") == 52) {
                List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(2, 4);
                res.put("message", "Probable focal seizure, Epilepsy check");
                res.put("questionSetName", "epilepsy");
                res.put("questionSet", questions);
                res.put("groupId", 2);
                res.put("subGroupId", 4);
            } else {
                res.put("message", "Uncertain for Seizure");
                res.put("questionSetName", null);
                res.put("questionSet", null);
                res.put("groupId", null);
                res.put("subGroupId", null);
            }

        } else if ((int) payload.get("subGroupId") == 4) {
            if ((int) answer.get("26") == 54) {
                res.put("message", "Epilepsy Diagnosis");
                res.put("questionSetName", null);
                res.put("questionSet", null);
                res.put("groupId", null);
                res.put("subGroupId", null);
            } else {
                res.put("message", "Uncertain for Epilepsy");
                res.put("questionSetName", null);
                res.put("questionSet", null);
                res.put("groupId", null);
                res.put("subGroupId", null);
            }
        } else if ((int) payload.get("subGroupId") == 5) {
            if ((int) answer.get("27") == 56) {
                List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(2, 7);
                res.put("message", "");
                res.put("questionSetName", "epilepsy");
                res.put("questionSet", questions);
                res.put("groupId", 2);
                res.put("subGroupId", 7);
            } else {
                List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(2, 6);
                res.put("message", "");
                res.put("questionSetName", "epilepsy");
                res.put("questionSet", questions);
                res.put("groupId", 2);
                res.put("subGroupId", 6);
            }
        } else if ((int) payload.get("subGroupId") == 6) {
            if ((int) answer.get("28") == 58 || (int) answer.get("29") == 60 || (int) answer.get("32") == 66 || (int) answer.get("33") == 68) {

                res.put("message", "Typical absence seizures");
                res.put("questionSetName", null);
                res.put("questionSet", null);
                res.put("groupId", null);
                res.put("subGroupId", null);
            } else {
                if ((int) answer.get("30") == 62 || (int) answer.get("31") == 64) {
                    res.put("message", "Probablr absence seizures");
                    res.put("questionSetName", null);
                    res.put("questionSet", null);
                    res.put("groupId", null);
                    res.put("subGroupId", null);
                } else {
                    res.put("message", "Generalised seizure");
                    res.put("questionSetName", null);
                    res.put("questionSet", null);
                    res.put("groupId", null);
                    res.put("subGroupId", null);
                }
            }
        } else if ((int) payload.get("subGroupId") == 7) {
            if (((int) answer.get("34") == 70 || (int) answer.get("35") == 72 || (int) answer.get("36") == 74 || (int) answer.get("37") == 76 || (int) answer.get("38") == 78 || (int) answer.get("39") == 80) && (int) answer.get("40") == 82) {
                res.put("message", "Typical febril siezure");
                res.put("questionSetName", null);
                res.put("questionSet", null);
                res.put("groupId", null);
                res.put("subGroupId", null);
            } else {
                res.put("message", "Atypical febrile siezure");
                res.put("questionSetName", null);
                res.put("questionSet", null);
                res.put("groupId", null);
                res.put("subGroupId", null);
            }
        }
        return res;
    }

    Map<String, Object> strokeProtocol(Map<String, Object> payload) {
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> answer = (Map) payload.get("questionsAnswers");

        if ((int) payload.get("groupId") == 1) {
            List<QuestionnaireEntity> questions = this.questionnaireRepository.findByGroupId(2, 1);
            res.put("message", "There is chance of epilepsy diagnostic protocol");
            res.put("questionSetName", "epilepsy");
            res.put("questionSet", questions);
            res.put("groupId", 2);
            res.put("subGroupId", 1);

        }

        return res;
    }
}
