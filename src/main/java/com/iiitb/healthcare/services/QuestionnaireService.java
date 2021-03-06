package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.entities.*;
import com.iiitb.healthcare.repo.PatientQuestionnaireAnswerRepository;
import com.iiitb.healthcare.repo.PatientQuestionnaireRepository;
import com.iiitb.healthcare.repo.QuestionnaireDiagnosisRepository;
import com.iiitb.healthcare.repo.QuestionnaireRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionnaireDiagnosisRepository questionnaireDiagnosisRepository;
    private final PatientQuestionnaireRepository patientQuestionnaireRepository;
    private final PatientQuestionnaireAnswerRepository patientQuestionnaireAnswerRepository;
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository, QuestionnaireDiagnosisRepository questionnaireDiagnosisRepository, PatientQuestionnaireRepository patientQuestionnaireRepository, PatientQuestionnaireAnswerRepository patientQuestionnaireAnswerRepository) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionnaireDiagnosisRepository = questionnaireDiagnosisRepository;
        this.patientQuestionnaireRepository = patientQuestionnaireRepository;
        this.patientQuestionnaireAnswerRepository = patientQuestionnaireAnswerRepository;
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

    public PatientQuestionnaireEntity saveAnswers(Map<String,Object> payload,Long loggedInUserId)
    {
        PatientQuestionnaireEntity questionnaire = new PatientQuestionnaireEntity();
        questionnaire.setPatientId((long)((Integer)payload.get("patientId")));
        System.out.println(questionnaire.getPatientId());
        System.out.println("get patient id");
        questionnaire.setReachedDiagnosisId((long)((Integer)payload.get("Result")));
        Date date = new Date();
        questionnaire.setPerformedOn(new Timestamp(date.getTime()));
        questionnaire.setPerformedByUserId(loggedInUserId);
        System.out.println(questionnaire.toString());
        PatientQuestionnaireEntity questionnaire1 = this.patientQuestionnaireRepository.save(questionnaire);
        System.out.println(payload.get("Answers").toString());
        List<Map<String,Object>> answers = (List<Map<String,Object>>) payload.get("Answers");
        for(Map<String,Object> answer : answers)
        {
            Map<String,Integer> qa = (Map<String,Integer>)answer.get("questionsAnswers");
            for(Map.Entry<String ,Integer> entry : qa.entrySet())
            {
                PatientQuestionnaireAnswerEntity row = new PatientQuestionnaireAnswerEntity();
                row.setPatientQuestionnaireId(questionnaire1.getId());
                row.setQuestionId(Long.parseLong(entry.getKey()));
                row.setSelectedOptionId((long)(entry.getValue()));
                patientQuestionnaireAnswerRepository.save(row);
            }

        }
        return questionnaire1;
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
            System.out.println(yes);
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
                QuestionnaireDiagnosisEntity result = questionnaireDiagnosisRepository.getById((long)2);
                res.put("result", result);
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
                QuestionnaireDiagnosisEntity result = questionnaireDiagnosisRepository.getById((long)2);
                res.put("result", result);
                res.put("questionSetName", null);
                res.put("questionSet", null);
                res.put("groupId", null);
                res.put("subGroupId", null);
            }

        } else if ((int) payload.get("subGroupId") == 4) {
            if ((int) answer.get("26") == 54) {
                QuestionnaireDiagnosisEntity result = questionnaireDiagnosisRepository.getById((long)4);
                res.put("result", result);
                res.put("questionSetName", null);
                res.put("questionSet", null);
                res.put("groupId", null);
                res.put("subGroupId", null);
            } else {
                QuestionnaireDiagnosisEntity result = questionnaireDiagnosisRepository.getById((long)3);
                res.put("result", result);
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

                QuestionnaireDiagnosisEntity result = questionnaireDiagnosisRepository.getById((long)5);
                res.put("result", result);
                res.put("questionSetName", null);
                res.put("questionSet", null);
                res.put("groupId", null);
                res.put("subGroupId", null);
            } else {
                if ((int) answer.get("30") == 62 || (int) answer.get("31") == 64) {
                    QuestionnaireDiagnosisEntity result = questionnaireDiagnosisRepository.getById((long)6);
                    res.put("result", result);
                    res.put("questionSetName", null);
                    res.put("questionSet", null);
                    res.put("groupId", null);
                    res.put("subGroupId", null);
                } else {
                    QuestionnaireDiagnosisEntity result = questionnaireDiagnosisRepository.getById((long)7);
                    res.put("result", result);
                    res.put("questionSetName", null);
                    res.put("questionSet", null);
                    res.put("groupId", null);
                    res.put("subGroupId", null);
                }
            }
        } else if ((int) payload.get("subGroupId") == 7) {
            if (((int) answer.get("34") == 70 || (int) answer.get("35") == 72 || (int) answer.get("36") == 74 || (int) answer.get("37") == 76 || (int) answer.get("38") == 78 || (int) answer.get("39") == 80) && (int) answer.get("40") == 82) {
                QuestionnaireDiagnosisEntity result = questionnaireDiagnosisRepository.getById((long)8);
                res.put("result", result);
                res.put("questionSetName", null);
                res.put("questionSet", null);
                res.put("groupId", null);
                res.put("subGroupId", null);
            } else {
                QuestionnaireDiagnosisEntity result = questionnaireDiagnosisRepository.getById((long)9);
                res.put("result", result);
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
