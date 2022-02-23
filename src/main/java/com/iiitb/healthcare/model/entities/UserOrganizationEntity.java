package com.iiitb.healthcare.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UserOrganization", schema = "BrainHealthInitiative", catalog = "")
public class UserOrganizationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @NotNull
    @Column(name = "UserId")
    private long userId;
    @Basic
    @NotNull
    @Column(name = "OrganizationId")
    private long organizationId;
    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private UserEntity userByUserId;
    @ManyToOne
    @JoinColumn(name = "OrganizationId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private OrganizationEntity organizationByOrganizationId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOrganizationEntity that = (UserOrganizationEntity) o;
        return id == that.id && userId == that.userId && organizationId == that.organizationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, organizationId);
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public OrganizationEntity getOrganizationByOrganizationId() {
        return organizationByOrganizationId;
    }

    public void setOrganizationByOrganizationId(OrganizationEntity organizationByOrganizationId) {
        this.organizationByOrganizationId = organizationByOrganizationId;
    }
}
