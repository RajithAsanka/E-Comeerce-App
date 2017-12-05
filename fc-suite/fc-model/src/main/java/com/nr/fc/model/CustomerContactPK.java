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
 * @author Naveen
 */
@Embeddable
public class CustomerContactPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "customer_id")
    private String customerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "contact_category")
    private String contactCategory;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "contact_type")
    private String contactType;

    public CustomerContactPK() {
    }

    public CustomerContactPK(String customerId, String contactCategory, String contactType) {
        this.customerId = customerId;
        this.contactCategory = contactCategory;
        this.contactType = contactType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getContactCategory() {
        return contactCategory;
    }

    public void setContactCategory(String contactCategory) {
        this.contactCategory = contactCategory;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        hash += (contactCategory != null ? contactCategory.hashCode() : 0);
        hash += (contactType != null ? contactType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerContactPK)) {
            return false;
        }
        CustomerContactPK other = (CustomerContactPK) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        if ((this.contactCategory == null && other.contactCategory != null) || (this.contactCategory != null && !this.contactCategory.equals(other.contactCategory))) {
            return false;
        }
        if ((this.contactType == null && other.contactType != null) || (this.contactType != null && !this.contactType.equals(other.contactType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.CustomerContactPK[ customerId=" + customerId + ", contactCategory=" + contactCategory + ", contactType=" + contactType + " ]";
    }
    
}
