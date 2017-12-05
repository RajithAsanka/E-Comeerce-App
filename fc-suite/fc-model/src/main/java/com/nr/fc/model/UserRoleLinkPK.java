/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Rajith
 */
@Embeddable
public class UserRoleLinkPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "role_code")
    private String roleCode;

    public UserRoleLinkPK() {
    }

    public UserRoleLinkPK(String userName, String roleCode) {
        this.userName = userName;
        this.roleCode = roleCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        hash += (roleCode != null ? roleCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoleLinkPK)) {
            return false;
        }
        UserRoleLinkPK other = (UserRoleLinkPK) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        if ((this.roleCode == null && other.roleCode != null) || (this.roleCode != null && !this.roleCode.equals(other.roleCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.UserRoleLinkPK[ userName=" + userName + ", roleCode=" + roleCode + " ]";
    }
    
}
