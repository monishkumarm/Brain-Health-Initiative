package com.iiitb.healthcare.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PatientQuestionnaire", schema = "BrainHealthInitiative", catalog = "")
public class PatientQuestionnaireEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Basic
    @Column(name = "PatientId")
    private Long patientId;
    @Basic
    @Column(name = "PerformedByUserId")
    private Long performedByUserId;
    @Basic
    @Column(name = "PerformedOn")
    private Timestamp performedOn;
    @Basic
    @Column(name = "ReachedDiagnosisId")
    private Long reachedDiagnosisId;
    @ManyToOne
    @JoinColumn(name = "PatientId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private PatientEntity patientByPatientId;
    @ManyToOne
    @JoinColumn(name = "PerformedByUserId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private UserEntity userByPerformedByUserId;
    @ManyToOne
    @JoinColumn(name = "ReachedDiagnosisId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private QuestionnaireDiagnosisEntity questionnaireDiagnosisByReachedDiagnosisId;
    @OneToMany(mappedBy = "patientQuestionnaireByPatientQuestionnaireId")
    private Collection<PatientQuestionnaireAnswerEntity> patientQuestionnaireAnswersById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getPerformedByUserId() {
        return performedByUserId;
    }

    public void setPerformedByUserId(Long performedByUserId) {
        this.performedByUserId = performedByUserId;
    }

    public Timestamp getPerformedOn() {
        return performedOn;
    }

    public void setPerformedOn(Timestamp performedOn) {
        this.performedOn = performedOn;
    }

    public Long getReachedDiagnosisId() {
        return reachedDiagnosisId;
    }

    public void setReachedDiagnosisId(Long reachedDiagnosisId) {
        this.reachedDiagnosisId = reachedDiagnosisId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientQuestionnaireEntity that = (PatientQuestionnaireEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(patientId, that.patientId) && Objects.equals(performedByUserId, that.performedByUserId) && Objects.equals(performedOn, that.performedOn) && Objects.equals(reachedDiagnosisId, that.reachedDiagnosisId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, performedByUserId, performedOn, reachedDiagnosisId);
    }

    public PatientEntity getPatientByPatientId() {
        return patientByPatientId;
    }

    public void setPatientByPatientId(PatientEntity patientByPatientId) {
        this.patientByPatientId = patientByPatientId;
    }

    public UserEntity getUserByPerformedByUserId() {
        return userByPerformedByUserId;
    }

    public void setUserByPerformedByUserId(UserEntity userByPerformedByUserId) {
        this.userByPerformedByUserId = userByPerformedByUserId;
    }

    public QuestionnaireDiagnosisEntity getQuestionnaireDiagnosisByReachedDiagnosisId() {
        return questionnaireDiagnosisByReachedDiagnosisId;
    }

    public void setQuestionnaireDiagnosisByReachedDiagnosisId(QuestionnaireDiagnosisEntity questionnaireDiagnosisByReachedDiagnosisId) {
        this.questionnaireDiagnosisByReachedDiagnosisId = questionnaireDiagnosisByReachedDiagnosisId;
    }

    public Collection<PatientQuestionnaireAnswerEntity> getPatientQuestionnaireAnswersById() {
        return patientQuestionnaireAnswersById;
    }

    public void setPatientQuestionnaireAnswersById(Collection<PatientQuestionnaireAnswerEntity> patientQuestionnaireAnswersById) {
        this.patientQuestionnaireAnswersById = patientQuestionnaireAnswersById;
    }
}