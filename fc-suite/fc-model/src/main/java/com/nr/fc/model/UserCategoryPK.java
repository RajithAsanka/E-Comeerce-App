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
public class UserCategoryPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_category")
    private String userCategory;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_type")
    private String userType;

    public UserCategoryPK() {
    }

    public UserCategoryPK(String userCategory, String userType) {
        this.userCategory = userCategory;
        this.userType = userType;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userCategory != null ? userCategory.hashCode() : 0);
        hash += (userType != null ? userType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCategoryPK)) {
            return false;
        }
        UserCategoryPK other = (UserCategoryPK) object;
        if ((this.userCategory == null && other.userCategory != null) || (this.userCategory != null && !this.userCategory.equals(other.userCategory))) {
            return false;
        }
        if ((this.userType == null && other.userType != null) || (this.userType != null && !this.userType.equals(other.userType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.UserCategoryPK[ userCategory=" + userCategory + ", userType=" + userType + " ]";
    }
    
}
