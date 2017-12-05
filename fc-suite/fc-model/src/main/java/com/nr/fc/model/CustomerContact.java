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
 * @author Naveen
 */
@Entity
@Table(name = "fc_customer_contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerContact.findAll", query = "SELECT c FROM CustomerContact c"),
    @NamedQuery(name = "CustomerContact.findByCustomerId", query = "SELECT c FROM CustomerContact c WHERE c.customerContactPK.customerId = :customerId"),
    @NamedQuery(name = "CustomerContact.findByContactCategory", query = "SELECT c FROM CustomerContact c WHERE c.customerContactPK.contactCategory = :contactCategory"),
    @NamedQuery(name = "CustomerContact.findByContactType", query = "SELECT c FROM CustomerContact c WHERE c.customerContactPK.contactType = :contactType"),
    @NamedQuery(name = "CustomerContact.findByContact", query = "SELECT c FROM CustomerContact c WHERE c.contact = :contact"),
    @NamedQuery(name = "CustomerContact.findByModifiedBy", query = "SELECT c FROM CustomerContact c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CustomerContact.findByModifiedDate", query = "SELECT c FROM CustomerContact c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "CustomerContact.findByStatus", query = "SELECT c FROM CustomerContact c WHERE c.status = :status"),
    @NamedQuery(name = "CustomerContact.findByAddedBy", query = "SELECT c FROM CustomerContact c WHERE c.addedBy = :addedBy"),
    @NamedQuery(name = "CustomerContact.findByAddedDate", query = "SELECT c FROM CustomerContact c WHERE c.addedDate = :addedDate")})
public class CustomerContact implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomerContactPK customerContactPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contact")
    private String contact;
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
    @Temporal(TemporalType.DATE)
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
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;

    public CustomerContact() {
    }

    public CustomerContact(CustomerContactPK customerContactPK) {
        this.customerContactPK = customerContactPK;
    }

    public CustomerContact(CustomerContactPK customerContactPK, String contact, String modifiedBy, Date modifiedDate, String status, String addedBy, Date addedDate) {
        this.customerContactPK = customerContactPK;
        this.contact = contact;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
    }

    public CustomerContact(String customerId, String contactCategory, String contactType) {
        this.customerContactPK = new CustomerContactPK(customerId, contactCategory, contactType);
    }

    public CustomerContactPK getCustomerContactPK() {
        return customerContactPK;
    }

    public void setCustomerContactPK(CustomerContactPK customerContactPK) {
        this.customerContactPK = customerContactPK;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerContactPK != null ? customerContactPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerContact)) {
            return false;
        }
        CustomerContact other = (CustomerContact) object;
        if ((this.customerContactPK == null && other.customerContactPK != null) || (this.customerContactPK != null && !this.customerContactPK.equals(other.customerContactPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.CustomerContact[ customerContactPK=" + customerContactPK + " ]";
    }
    
}
