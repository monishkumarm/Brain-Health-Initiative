package com.iiitb.healthcare.model.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "QuestionnaireOption", schema = "BrainHealthInitiative", catalog = "")
public class QuestionnaireOptionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private Long id;
    @Basic
    @Column(name = "QuestionId")
    private Long questionId;
    @Basic
    @Column(name = "Option")
    private String option;
    @OneToMany(mappedBy = "questionnaireOptionBySelectedOptionId")
    private Collection<PatientQuestionnaireAnswerEntity> patientQuestionnaireAnswersById;
    @ManyToOne
    @JoinColumn(name = "QuestionId", referencedColumnName = "Id")
    private QuestionnaireEntity questionnaireByQuestionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionnaireOptionEntity that = (QuestionnaireOptionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(questionId, that.questionId) && Objects.equals(option, that.option);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionId, option);
    }

    public Collection<PatientQuestionnaireAnswerEntity> getPatientQuestionnaireAnswersById() {
        return patientQuestionnaireAnswersById;
    }

    public void setPatientQuestionnaireAnswersById(Collection<PatientQuestionnaireAnswerEntity> patientQuestionnaireAnswersById) {
        this.patientQuestionnaireAnswersById = patientQuestionnaireAnswersById;
    }

    public QuestionnaireEntity getQuestionnaireByQuestionId() {
        return questionnaireByQuestionId;
    }

    public void setQuestionnaireByQuestionId(QuestionnaireEntity questionnaireByQuestionId) {
        this.questionnaireByQuestionId = questionnaireByQuestionId;
    }
}
