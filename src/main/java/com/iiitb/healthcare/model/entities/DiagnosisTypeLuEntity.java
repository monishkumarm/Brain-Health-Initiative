package com.iiitb.healthcare.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "DiagnosisType_lu", schema = "BrainHealthInitiative", catalog = "")
public class DiagnosisTypeLuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private int id;
    @Basic
    @NotNull
    @Column(name = "Name", unique=true)
    private String name;
    @OneToMany(mappedBy = "diagnosisTypeLuByDiagnosisTypeId")
    private Collection<PatientConsultationEntity> patientConsultationsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagnosisTypeLuEntity that = (DiagnosisTypeLuEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Collection<PatientConsultationEntity> getPatientConsultationsById() {
        return patientConsultationsById;
    }

    public void setPatientConsultationsById(Collection<PatientConsultationEntity> patientConsultationsById) {
        this.patientConsultationsById = patientConsultationsById;
    }
}
