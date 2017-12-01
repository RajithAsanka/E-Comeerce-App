/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rajith
 */
@Entity
@Table(name = "fc_user_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserCategory.findAll", query = "SELECT u FROM UserCategory u"),
    @NamedQuery(name = "UserCategory.findByAddedBy", query = "SELECT u FROM UserCategory u WHERE u.addedBy = :addedBy"),
    @NamedQuery(name = "UserCategory.findByAddedDate", query = "SELECT u FROM UserCategory u WHERE u.addedDate = :addedDate"),
    @NamedQuery(name = "UserCategory.findByModifiedBy", query = "SELECT u FROM UserCategory u WHERE u.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "UserCategory.findByModifiedDate", query = "SELECT u FROM UserCategory u WHERE u.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "UserCategory.findByStatus", query = "SELECT u FROM UserCategory u WHERE u.status = :status"),
    @NamedQuery(name = "UserCategory.findByUserCategory", query = "SELECT u FROM UserCategory u WHERE u.userCategoryPK.userCategory = :userCategory"),
    @NamedQuery(name = "UserCategory.findByUserType", query = "SELECT u FROM UserCategory u WHERE u.userCategoryPK.userType = :userType")})
public class UserCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserCategoryPK userCategoryPK;
    @Size(max = 20)
    @Column(name = "added_by")
    private String addedBy;
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 20)
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Size(max = 20)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userCategory")
    private List<Role> roleList;
    @JoinColumn(name = "user_type", referencedColumnName = "user_type", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserType userType;

    public UserCategory() {
    }

    public UserCategory(UserCategoryPK userCategoryPK) {
        this.userCategoryPK = userCategoryPK;
    }

    public UserCategory(String userCategory, String userType) {
        this.userCategoryPK = new UserCategoryPK(userCategory, userType);
    }

    public UserCategoryPK getUserCategoryPK() {
        return userCategoryPK;
    }

    public void setUserCategoryPK(UserCategoryPK userCategoryPK) {
        this.userCategoryPK = userCategoryPK;
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
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userCategoryPK != null ? userCategoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCategory)) {
            return false;
        }
        UserCategory other = (UserCategory) object;
        if ((this.userCategoryPK == null && other.userCategoryPK != null) || (this.userCategoryPK != null && !this.userCategoryPK.equals(other.userCategoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.UserCategory[ userCategoryPK=" + userCategoryPK + " ]";
    }

}
