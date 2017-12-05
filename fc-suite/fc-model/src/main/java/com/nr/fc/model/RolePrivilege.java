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
@Table(name = "fc_role_privilege")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolePrivilege.findAll", query = "SELECT r FROM RolePrivilege r"),
    @NamedQuery(name = "RolePrivilege.findByRoleCode", query = "SELECT r FROM RolePrivilege r WHERE r.rolePrivilegePK.roleCode = :roleCode"),
    @NamedQuery(name = "RolePrivilege.findByPrivilegeName", query = "SELECT r FROM RolePrivilege r WHERE r.rolePrivilegePK.privilegeName = :privilegeName"),
    @NamedQuery(name = "RolePrivilege.findByStatus", query = "SELECT r FROM RolePrivilege r WHERE r.status = :status"),
    @NamedQuery(name = "RolePrivilege.findByAddedBy", query = "SELECT r FROM RolePrivilege r WHERE r.addedBy = :addedBy"),
    @NamedQuery(name = "RolePrivilege.findByAddedDate", query = "SELECT r FROM RolePrivilege r WHERE r.addedDate = :addedDate")})
public class RolePrivilege implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolePrivilegePK rolePrivilegePK;
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
    @JoinColumn(name = "role_code", referencedColumnName = "role_code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;
    @JoinColumn(name = "privilege_name", referencedColumnName = "privilege_name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Privilege privilege;

    public RolePrivilege() {
    }

    public RolePrivilege(RolePrivilegePK rolePrivilegePK) {
        this.rolePrivilegePK = rolePrivilegePK;
    }

    public RolePrivilege(RolePrivilegePK rolePrivilegePK, String status, String addedBy, Date addedDate) {
        this.rolePrivilegePK = rolePrivilegePK;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
    }

    public RolePrivilege(String roleCode, String privilegeName) {
        this.rolePrivilegePK = new RolePrivilegePK(roleCode, privilegeName);
    }

    public RolePrivilegePK getRolePrivilegePK() {
        return rolePrivilegePK;
    }

    public void setRolePrivilegePK(RolePrivilegePK rolePrivilegePK) {
        this.rolePrivilegePK = rolePrivilegePK;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolePrivilegePK != null ? rolePrivilegePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolePrivilege)) {
            return false;
        }
        RolePrivilege other = (RolePrivilege) object;
        if ((this.rolePrivilegePK == null && other.rolePrivilegePK != null) || (this.rolePrivilegePK != null && !this.rolePrivilegePK.equals(other.rolePrivilegePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.RolePrivilege[ rolePrivilegePK=" + rolePrivilegePK + " ]";
    }
    
}
