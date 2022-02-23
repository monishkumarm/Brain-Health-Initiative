package com.iiitb.healthcare.model.entities;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Organization", schema = "BrainHealthInitiative", catalog = "")
public class OrganizationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @NotNull
    @Column(name = "Name", unique=true)
    private String name;
    @Basic
    @NotNull
    @Column(name = "AddressDetail", columnDefinition = "json")
    @JsonRawValue
    private String addressDetail;
    @Basic
    @NotNull
    @Column(name = "IsActive")
    private boolean isActive;
    @OneToMany(mappedBy = "organizationByOrganizationId")
    private Collection<UserOrganizationEntity> userOrganizationsById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationEntity that = (OrganizationEntity) o;
        return id == that.id && isActive == that.isActive && Objects.equals(name, that.name) && Objects.equals(addressDetail, that.addressDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addressDetail, isActive);
    }

    public Collection<UserOrganizationEntity> getUserOrganizationsById() {
        return userOrganizationsById;
    }

    public void setUserOrganizationsById(Collection<UserOrganizationEntity> userOrganizationsById) {
        this.userOrganizationsById = userOrganizationsById;
    }
}
