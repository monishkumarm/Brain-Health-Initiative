package com.iiitb.healthcare.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PatientQuestionnaireAnswer", schema = "BrainHealthInitiative", catalog = "")
public class PatientQuestionnaireAnswerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private Long id;
    @Basic
    @Column(name = "PatientQuestionnaireId")
    private Long patientQuestionnaireId;
    @Basic
    @Column(name = "QuestionId")
    private Long questionId;
    @Basic
    @Column(name = "SelectedOptionId")
    private Long selectedOptionId;
    @ManyToOne
    @JoinColumn(name = "PatientQuestionnaireId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private PatientQuestionnaireEntity patientQuestionnaireByPatientQuestionnaireId;
    @ManyToOne
    @JoinColumn(name = "QuestionId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private QuestionnaireEntity questionnaireByQuestionId;
    @ManyToOne
    @JoinColumn(name = "SelectedOptionId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private QuestionnaireOptionEntity questionnaireOptionBySelectedOptionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientQuestionnaireId() {
        return patientQuestionnaireId;
    }

    public void setPatientQuestionnaireId(Long patientQuestionnaireId) {
        this.patientQuestionnaireId = patientQuestionnaireId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getSelectedOptionId() {
        return selectedOptionId;
    }

    public void setSelectedOptionId(Long selectedOptionId) {
        this.selectedOptionId = selectedOptionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientQuestionnaireAnswerEntity that = (PatientQuestionnaireAnswerEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(patientQuestionnaireId, that.patientQuestionnaireId) && Objects.equals(questionId, that.questionId) && Objects.equals(selectedOptionId, that.selectedOptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientQuestionnaireId, questionId, selectedOptionId);
    }

    public PatientQuestionnaireEntity getPatientQuestionnaireByPatientQuestionnaireId() {
        return patientQuestionnaireByPatientQuestionnaireId;
    }

    public void setPatientQuestionnaireByPatientQuestionnaireId(PatientQuestionnaireEntity patientQuestionnaireByPatientQuestionnaireId) {
        this.patientQuestionnaireByPatientQuestionnaireId = patientQuestionnaireByPatientQuestionnaireId;
    }

    public QuestionnaireEntity getQuestionnaireByQuestionId() {
        return questionnaireByQuestionId;
    }

    public void setQuestionnaireByQuestionId(QuestionnaireEntity questionnaireByQuestionId) {
        this.questionnaireByQuestionId = questionnaireByQuestionId;
    }

    public QuestionnaireOptionEntity getQuestionnaireOptionBySelectedOptionId() {
        return questionnaireOptionBySelectedOptionId;
    }

    public void setQuestionnaireOptionBySelectedOptionId(QuestionnaireOptionEntity questionnaireOptionBySelectedOptionId) {
        this.questionnaireOptionBySelectedOptionId = questionnaireOptionBySelectedOptionId;
    }
}
