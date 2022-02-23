package com.iiitb.healthcare.model.entities;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "User", schema = "BrainHealthInitiative", catalog = "")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @NotNull
    @Column(name = "Username", unique=true)
    private String username;
    @Basic
    @NotNull
    @Column(name = "FullName")
    private String fullName;
    @Basic
    @NotNull
    @Column(name = "RoleTypeId")
    private int roleTypeId;
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
    @Column(name = "TimeZoneId")
    private int timeZoneId;
    @Basic
    @NotNull
    @Column(name = "AddressDetail", columnDefinition = "json")
    @JsonRawValue
    private String addressDetail;
    @Basic
    @NotNull
    @Column(name = "Password")
    private String password;
    @Basic
    @NotNull
    @Column(name = "IsActive")
    private boolean isActive;
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
    @OneToMany(mappedBy = "userByCreatedBy")
    private Collection<PatientEntity> patientsById;
    @OneToMany(mappedBy = "userByLastChangeBy")
    private Collection<PatientEntity> patientsById_0;
    @OneToMany(mappedBy = "userByDoctorId")
    private Collection<PatientConsultationEntity> patientConsultationsById;
    @OneToMany(mappedBy = "userByReferredBy")
    private Collection<PatientConsultationEntity> patientConsultationsById_0;
    @ManyToOne
    @JoinColumn(name = "RoleTypeId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private RoleTypeLuEntity roleTypeLuByRoleTypeId;
    @ManyToOne
    @JoinColumn(name = "CreatedBy", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private UserEntity userByCreatedBy;
    @OneToMany(mappedBy = "userByCreatedBy")
    private Collection<UserEntity> usersById;
    @ManyToOne
    @JoinColumn(name = "LastChangeBy", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private UserEntity userByLastChangeBy;
    @OneToMany(mappedBy = "userByLastChangeBy")
    private Collection<UserEntity> usersById_0;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<UserOrganizationEntity> userOrganizationsById;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<UserPermissionPatientEntity> userPermissionPatientsById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRoleTypeId() {
        return roleTypeId;
    }

    public void setRoleTypeId(int roleTypeId) {
        this.roleTypeId = roleTypeId;
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

    public int getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(int timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
        UserEntity that = (UserEntity) o;
        return id == that.id && roleTypeId == that.roleTypeId && timeZoneId == that.timeZoneId && isActive == that.isActive && createdBy == that.createdBy && lastChangeBy == that.lastChangeBy && Objects.equals(username, that.username) && Objects.equals(fullName, that.fullName) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(addressDetail, that.addressDetail) && Objects.equals(password, that.password) && Objects.equals(createdOn, that.createdOn) && Objects.equals(lastChangeOn, that.lastChangeOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, fullName, roleTypeId, email, phoneNumber, timeZoneId, addressDetail, password, isActive, createdOn, createdBy, lastChangeOn, lastChangeBy);
    }

    public Collection<PatientEntity> getPatientsById() {
        return patientsById;
    }

    public void setPatientsById(Collection<PatientEntity> patientsById) {
        this.patientsById = patientsById;
    }

    public Collection<PatientEntity> getPatientsById_0() {
        return patientsById_0;
    }

    public void setPatientsById_0(Collection<PatientEntity> patientsById_0) {
        this.patientsById_0 = patientsById_0;
    }

    public Collection<PatientConsultationEntity> getPatientConsultationsById() {
        return patientConsultationsById;
    }

    public void setPatientConsultationsById(Collection<PatientConsultationEntity> patientConsultationsById) {
        this.patientConsultationsById = patientConsultationsById;
    }

    public Collection<PatientConsultationEntity> getPatientConsultationsById_0() {
        return patientConsultationsById_0;
    }

    public void setPatientConsultationsById_0(Collection<PatientConsultationEntity> patientConsultationsById_0) {
        this.patientConsultationsById_0 = patientConsultationsById_0;
    }

    public RoleTypeLuEntity getRoleTypeLuByRoleTypeId() {
        return roleTypeLuByRoleTypeId;
    }

    public void setRoleTypeLuByRoleTypeId(RoleTypeLuEntity roleTypeLuByRoleTypeId) {
        this.roleTypeLuByRoleTypeId = roleTypeLuByRoleTypeId;
    }

    public UserEntity getUserByCreatedBy() {
        return userByCreatedBy;
    }

    public void setUserByCreatedBy(UserEntity userByCreatedBy) {
        this.userByCreatedBy = userByCreatedBy;
    }

    public Collection<UserEntity> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<UserEntity> usersById) {
        this.usersById = usersById;
    }

    public UserEntity getUserByLastChangeBy() {
        return userByLastChangeBy;
    }

    public void setUserByLastChangeBy(UserEntity userByLastChangeBy) {
        this.userByLastChangeBy = userByLastChangeBy;
    }

    public Collection<UserEntity> getUsersById_0() {
        return usersById_0;
    }

    public void setUsersById_0(Collection<UserEntity> usersById_0) {
        this.usersById_0 = usersById_0;
    }

    public Collection<UserOrganizationEntity> getUserOrganizationsById() {
        return userOrganizationsById;
    }

    public void setUserOrganizationsById(Collection<UserOrganizationEntity> userOrganizationsById) {
        this.userOrganizationsById = userOrganizationsById;
    }

    public Collection<UserPermissionPatientEntity> getUserPermissionPatientsById() {
        return userPermissionPatientsById;
    }

    public void setUserPermissionPatientsById(Collection<UserPermissionPatientEntity> userPermissionPatientsById) {
        this.userPermissionPatientsById = userPermissionPatientsById;
    }
}
