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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "fc_user_password_audit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPasswordAudit.findAll", query = "SELECT u FROM UserPasswordAudit u"),
    @NamedQuery(name = "UserPasswordAudit.findById", query = "SELECT u FROM UserPasswordAudit u WHERE u.id = :id"),
    @NamedQuery(name = "UserPasswordAudit.findByModifiedBy", query = "SELECT u FROM UserPasswordAudit u WHERE u.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "UserPasswordAudit.findByModifiedDate", query = "SELECT u FROM UserPasswordAudit u WHERE u.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "UserPasswordAudit.findByStatus", query = "SELECT u FROM UserPasswordAudit u WHERE u.status = :status"),
    @NamedQuery(name = "UserPasswordAudit.findByAddedBy", query = "SELECT u FROM UserPasswordAudit u WHERE u.addedBy = :addedBy"),
    @NamedQuery(name = "UserPasswordAudit.findByAddedDate", query = "SELECT u FROM UserPasswordAudit u WHERE u.addedDate = :addedDate")})
public class UserPasswordAudit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "password")
    private String password;
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
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    @ManyToOne(optional = false)
    private User userName;

    public UserPasswordAudit() {
    }

    public UserPasswordAudit(String id) {
        this.id = id;
    }

    public UserPasswordAudit(String id, String password, String modifiedBy, Date modifiedDate, String status, String addedBy, Date addedDate) {
        this.id = id;
        this.password = password;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPasswordAudit)) {
            return false;
        }
        UserPasswordAudit other = (UserPasswordAudit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.UserPasswordAudit[ id=" + id + " ]";
    }
    
}
