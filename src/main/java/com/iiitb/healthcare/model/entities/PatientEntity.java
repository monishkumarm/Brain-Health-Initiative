package com.iiitb.healthcare.model.entities;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Patient", schema = "BrainHealthInitiative", catalog = "")
public class PatientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @NotNull
    @Column(name = "FullName")
    private String fullName;
    @Basic
    @NotNull
    @Column(name = "Gender")
    private int gender;
    @Basic
    @NotNull
    @Column(name = "Age")
    private int age;
    @Basic
    @NotNull
    @Column(name = "Email", unique=true)
    private String email;
    @Basic
    @NotNull
    @Column(name = "PhoneNumber", unique=true)
    private String phoneNumber;
    @Basic
    @NotNull
    @Column(name = "AddressDetail", columnDefinition = "json")
    @JsonRawValue
    private String addressDetail;
    @Basic
    @Column(name = "Languages")
    private String languages;
    @Basic
    @Column(name = "Education")
    private String education;
    @Basic
    @Column(name = "Occupation")
    private String occupation;
    @Basic
    @Column(name = "InformantCaregiverName")
    private String informantCaregiverName;
    @Basic
    @Column(name = "RelationshipWithPatient")
    private Integer relationshipWithPatient;
    @Basic
    @NotNull
    @Column(name = "CreatedOn")
    private Timestamp createdOn;
    @Basic
    @NotNull
    @Column(name = "CreatedBy")
    private long createdBy;
    @Basic
    @NotNull
    @Column(name = "LastChangeOn")
    private Timestamp lastChangeOn;
    @Basic
    @NotNull
    @Column(name = "LastChangeBy")
    private long lastChangeBy;
    @ManyToOne
    @JoinColumn(name = "CreatedBy", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private UserEntity userByCreatedBy;
    @ManyToOne
    @JoinColumn(name = "LastChangeBy", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private UserEntity userByLastChangeBy;
    @OneToMany(mappedBy = "patientByPatientId")
    private Collection<PatientConsultationEntity> patientConsultationsById;
    @OneToMany(mappedBy = "patientByPatientId")
    private Collection<UserPermissionPatientEntity> userPermissionPatientsById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getInformantCaregiverName() {
        return informantCaregiverName;
    }

    public void setInformantCaregiverName(String informantCaregiverName) {
        this.informantCaregiverName = informantCaregiverName;
    }

    public Integer getRelationshipWithPatient() {
        return relationshipWithPatient;
    }

    public void setRelationshipWithPatient(Integer relationshipWithPatient) {
        this.relationshipWithPatient = relationshipWithPatient;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getLastChangeOn() {
        return lastChangeOn;
    }

    public void setLastChangeOn(Timestamp lastChangeOn) {
        this.lastChangeOn = lastChangeOn;
    }

    public long getLastChangeBy() {
        return lastChangeBy;
    }

    public void setLastChangeBy(long lastChangeBy) {
        this.lastChangeBy = lastChangeBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientEntity that = (PatientEntity) o;
        return id == that.id && gender == that.gender && age == that.age && createdBy == that.createdBy && lastChangeBy == that.lastChangeBy && Objects.equals(fullName, that.fullName) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(addressDetail, that.addressDetail) && Objects.equals(languages, that.languages) && Objects.equals(education, that.education) && Objects.equals(occupation, that.occupation) && Objects.equals(informantCaregiverName, that.informantCaregiverName) && Objects.equals(relationshipWithPatient, that.relationshipWithPatient) && Objects.equals(createdOn, that.createdOn) && Objects.equals(lastChangeOn, that.lastChangeOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, gender, age, email, phoneNumber, addressDetail, languages, education, occupation, informantCaregiverName, relationshipWithPatient, createdOn, createdBy, lastChangeOn, lastChangeBy);
    }

    public UserEntity getUserByCreatedBy() {
        return userByCreatedBy;
    }

    public void setUserByCreatedBy(UserEntity userByCreatedBy) {
        this.userByCreatedBy = userByCreatedBy;
    }

    public UserEntity getUserByLastChangeBy() {
        return userByLastChangeBy;
    }

    public void setUserByLastChangeBy(UserEntity userByLastChangeBy) {
        this.userByLastChangeBy = userByLastChangeBy;
    }

    public Collection<PatientConsultationEntity> getPatientConsultationsById() {
        return patientConsultationsById;
    }

    public void setPatientConsultationsById(Collection<PatientConsultationEntity> patientConsultationsById) {
        this.patientConsultationsById = patientConsultationsById;
    }

    public Collection<UserPermissionPatientEntity> getUserPermissionPatientsById() {
        return userPermissionPatientsById;
    }

    public void setUserPermissionPatientsById(Collection<UserPermissionPatientEntity> userPermissionPatientsById) {
        this.userPermissionPatientsById = userPermissionPatientsById;
    }
}
