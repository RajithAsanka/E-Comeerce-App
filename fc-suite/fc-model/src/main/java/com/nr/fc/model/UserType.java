/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rajith
 */
@Entity
@Table(name = "fc_user_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserType.findAll", query = "SELECT u FROM UserType u"),
    @NamedQuery(name = "UserType.findByUserType", query = "SELECT u FROM UserType u WHERE u.userType = :userType"),
    @NamedQuery(name = "UserType.findByAddedBy", query = "SELECT u FROM UserType u WHERE u.addedBy = :addedBy"),
    @NamedQuery(name = "UserType.findByAddedDate", query = "SELECT u FROM UserType u WHERE u.addedDate = :addedDate"),
    @NamedQuery(name = "UserType.findByModifiedBy", query = "SELECT u FROM UserType u WHERE u.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "UserType.findByModifiedDate", query = "SELECT u FROM UserType u WHERE u.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "UserType.findByStatus", query = "SELECT u FROM UserType u WHERE u.status = :status")})
public class UserType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_type")
    private String userType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "added_by")
    private String addedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "modified_by")
    private String modifiedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userType")
    private List<UserCategory> userCategoryList;

    public UserType() {
    }

    public UserType(String userType) {
        this.userType = userType;
    }

    public UserType(String userType, String addedBy, Date addedDate, String modifiedBy, Date modifiedDate, String status) {
        this.userType = userType;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<UserCategory> getUserCategoryList() {
        return userCategoryList;
    }

    public void setUserCategoryList(List<UserCategory> userCategoryList) {
        this.userCategoryList = userCategoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userType != null ? userType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserType)) {
            return false;
        }
        UserType other = (UserType) object;
        if ((this.userType == null && other.userType != null) || (this.userType != null && !this.userType.equals(other.userType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.UserType[ userType=" + userType + " ]";
    }
    
}
