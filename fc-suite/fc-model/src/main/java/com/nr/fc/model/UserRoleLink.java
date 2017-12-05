/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rajith
 */
@Entity
@Table(name = "fc_user_role_link")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRoleLink.findAll", query = "SELECT u FROM UserRoleLink u"),
    @NamedQuery(name = "UserRoleLink.findByUserName", query = "SELECT u FROM UserRoleLink u WHERE u.userRoleLinkPK.userName = :userName"),
    @NamedQuery(name = "UserRoleLink.findByRoleCode", query = "SELECT u FROM UserRoleLink u WHERE u.userRoleLinkPK.roleCode = :roleCode"),
    @NamedQuery(name = "UserRoleLink.findByModifiedBy", query = "SELECT u FROM UserRoleLink u WHERE u.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "UserRoleLink.findByModifiedDate", query = "SELECT u FROM UserRoleLink u WHERE u.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "UserRoleLink.findByStatus", query = "SELECT u FROM UserRoleLink u WHERE u.status = :status"),
    @NamedQuery(name = "UserRoleLink.findByAddedBy", query = "SELECT u FROM UserRoleLink u WHERE u.addedBy = :addedBy"),
    @NamedQuery(name = "UserRoleLink.findByAddedDate", query = "SELECT u FROM UserRoleLink u WHERE u.addedDate = :addedDate")})
public class UserRoleLink implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserRoleLinkPK userRoleLinkPK;
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
    @JoinColumn(name = "user_name", referencedColumnName = "user_name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "role_code", referencedColumnName = "role_code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public UserRoleLink() {
    }

    public UserRoleLink(UserRoleLinkPK userRoleLinkPK) {
        this.userRoleLinkPK = userRoleLinkPK;
    }

    public UserRoleLink(UserRoleLinkPK userRoleLinkPK, String modifiedBy, Date modifiedDate, String status, String addedBy, Date addedDate) {
        this.userRoleLinkPK = userRoleLinkPK;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
    }

    public UserRoleLink(String userName, String roleCode) {
        this.userRoleLinkPK = new UserRoleLinkPK(userName, roleCode);
    }

    public UserRoleLinkPK getUserRoleLinkPK() {
        return userRoleLinkPK;
    }

    public void setUserRoleLinkPK(UserRoleLinkPK userRoleLinkPK) {
        this.userRoleLinkPK = userRoleLinkPK;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRoleLinkPK != null ? userRoleLinkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoleLink)) {
            return false;
        }
        UserRoleLink other = (UserRoleLink) object;
        if ((this.userRoleLinkPK == null && other.userRoleLinkPK != null) || (this.userRoleLinkPK != null && !this.userRoleLinkPK.equals(other.userRoleLinkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.UserRoleLink[ userRoleLinkPK=" + userRoleLinkPK + " ]";
    }
    
}
