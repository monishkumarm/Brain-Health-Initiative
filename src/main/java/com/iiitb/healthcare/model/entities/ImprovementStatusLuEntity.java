package com.iiitb.healthcare.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ImprovementStatus_lu", schema = "BrainHealthInitiative", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","patientConsultationsById"})
public class ImprovementStatusLuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private int id;
    @Basic
    @NotNull
    @Column(name = "Name", unique=true)
    private String name;
    @OneToMany(mappedBy = "improvementStatusLuByImprovementStatusId")
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
        ImprovementStatusLuEntity that = (ImprovementStatusLuEntity) o;
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
