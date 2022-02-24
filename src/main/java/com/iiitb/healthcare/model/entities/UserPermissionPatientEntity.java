package com.iiitb.healthcare.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UserPermissionPatient", schema = "BrainHealthInitiative", catalog = "", uniqueConstraints = {@UniqueConstraint(columnNames = {"patientId", "userId"})})
public class UserPermissionPatientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @NotNull
    @Column(name = "PatientId")
    private long patientId;
    @Basic
    @NotNull
    @Column(name = "UserId")
    private long userId;
    @Basic
    @NotNull
    @Column(name = "CanView")
    private boolean canView;
    @Basic
    @NotNull
    @Column(name = "CanModify")
    private boolean canModify;
    @Basic
    @NotNull
    @Column(name = "CanDelete")
    private boolean canDelete;
    @ManyToOne
    @JoinColumn(name = "PatientId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private PatientEntity patientByPatientId;
    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private UserEntity userByUserId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isCanView() {
        return canView;
    }

    public void setCanView(boolean canView) {
        this.canView = canView;
    }

    public boolean isCanModify() {
        return canModify;
    }

    public void setCanModify(boolean canModify) {
        this.canModify = canModify;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPermissionPatientEntity that = (UserPermissionPatientEntity) o;
        return id == that.id && patientId == that.patientId && userId == that.userId && canView == that.canView && canModify == that.canModify && canDelete == that.canDelete;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, userId, canView, canModify, canDelete);
    }

    public PatientEntity getPatientByPatientId() {
        return patientByPatientId;
    }

    public void setPatientByPatientId(PatientEntity patientByPatientId) {
        this.patientByPatientId = patientByPatientId;
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
