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
@Table(name = "fc_privilege")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilege.findAll", query = "SELECT p FROM Privilege p"),
    @NamedQuery(name = "Privilege.findByPrivilegeName", query = "SELECT p FROM Privilege p WHERE p.privilegeName = :privilegeName"),
    @NamedQuery(name = "Privilege.findByPrivilegeCode", query = "SELECT p FROM Privilege p WHERE p.privilegeCode = :privilegeCode"),
    @NamedQuery(name = "Privilege.findByStatus", query = "SELECT p FROM Privilege p WHERE p.status = :status"),
    @NamedQuery(name = "Privilege.findByAddedBy", query = "SELECT p FROM Privilege p WHERE p.addedBy = :addedBy"),
    @NamedQuery(name = "Privilege.findByAddedDate", query = "SELECT p FROM Privilege p WHERE p.addedDate = :addedDate")})
public class Privilege implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "privilege_name")
    private String privilegeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "privilege_code")
    private String privilegeCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "privilege")
    private List<RolePrivilege> rolePrivilegeList;

    public Privilege() {
    }

    public Privilege(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public Privilege(String privilegeName, String privilegeCode, String status, String addedBy, Date addedDate) {
        this.privilegeName = privilegeName;
        this.privilegeCode = privilegeCode;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @XmlTransient
    public List<RolePrivilege> getRolePrivilegeList() {
        return rolePrivilegeList;
    }

    public void setRolePrivilegeList(List<RolePrivilege> rolePrivilegeList) {
        this.rolePrivilegeList = rolePrivilegeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (privilegeName != null ? privilegeName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilege)) {
            return false;
        }
        Privilege other = (Privilege) object;
        if ((this.privilegeName == null && other.privilegeName != null) || (this.privilegeName != null && !this.privilegeName.equals(other.privilegeName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.Privilege[ privilegeName=" + privilegeName + " ]";
    }
    
}
