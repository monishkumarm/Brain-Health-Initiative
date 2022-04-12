package com.iiitb.healthcare.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Questionnaire", schema = "BrainHealthInitiative", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","patientQuestionnaireAnswersById"})

public class QuestionnaireEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private Long id;
    @Basic
    @Column(name = "Question")
    private String question;
    @Basic
    @Column(name = "GroupId")
    private Integer groupId;
    @Basic
    @Column(name = "SubGroupId")
    private Integer subGroupId;
    @OneToMany(mappedBy = "questionnaireByQuestionId")
    private Collection<PatientQuestionnaireAnswerEntity> patientQuestionnaireAnswersById;
    @OneToMany(mappedBy = "questionnaireByQuestionId")
    private Collection<QuestionnaireOptionEntity> questionnaireOptionsById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getSubGroupId() {
        return subGroupId;
    }

    public void setSubGroupId(Integer subGroupId) {
        this.subGroupId = subGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionnaireEntity that = (QuestionnaireEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(question, that.question) && Objects.equals(groupId, that.groupId) && Objects.equals(subGroupId, that.subGroupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, groupId, subGroupId);
    }

    public Collection<PatientQuestionnaireAnswerEntity> getPatientQuestionnaireAnswersById() {
        return patientQuestionnaireAnswersById;
    }

    public void setPatientQuestionnaireAnswersById(Collection<PatientQuestionnaireAnswerEntity> patientQuestionnaireAnswersById) {
        this.patientQuestionnaireAnswersById = patientQuestionnaireAnswersById;
    }

    public Collection<QuestionnaireOptionEntity> getQuestionnaireOptionsById() {
        return questionnaireOptionsById;
    }

    public void setQuestionnaireOptionsById(Collection<QuestionnaireOptionEntity> questionnaireOptionsById) {
        this.questionnaireOptionsById = questionnaireOptionsById;
    }
}
