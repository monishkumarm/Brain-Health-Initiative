package com.iiitb.healthcare.model.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "QuestionnaireDiagnosis", schema = "BrainHealthInitiative", catalog = "")
public class QuestionnaireDiagnosisEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private Long id;
    @Basic
    @Column(name = "DiagnosisInfo")
    private String diagnosisInfo;
    @OneToMany(mappedBy = "questionnaireDiagnosisByReachedDiagnosisId")
    private Collection<PatientQuestionnaireEntity> patientQuestionnairesById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnosisInfo() {
        return diagnosisInfo;
    }

    public void setDiagnosisInfo(String diagnosisInfo) {
        this.diagnosisInfo = diagnosisInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionnaireDiagnosisEntity that = (QuestionnaireDiagnosisEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(diagnosisInfo, that.diagnosisInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, diagnosisInfo);
    }

    public Collection<PatientQuestionnaireEntity> getPatientQuestionnairesById() {
        return patientQuestionnairesById;
    }

    public void setPatientQuestionnairesById(Collection<PatientQuestionnaireEntity> patientQuestionnairesById) {
        this.patientQuestionnairesById = patientQuestionnairesById;
    }
}
