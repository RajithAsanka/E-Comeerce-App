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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "fc_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerGroup.findAll", query = "SELECT c FROM CustomerGroup c"),
    @NamedQuery(name = "CustomerGroup.findByGroupId", query = "SELECT c FROM CustomerGroup c WHERE c.groupId = :groupId"),
    @NamedQuery(name = "CustomerGroup.findByGroupName", query = "SELECT c FROM CustomerGroup c WHERE c.groupName = :groupName"),
    @NamedQuery(name = "CustomerGroup.findByDateOfEstablishment", query = "SELECT c FROM CustomerGroup c WHERE c.dateOfEstablishment = :dateOfEstablishment"),
    @NamedQuery(name = "CustomerGroup.findByMeetingDate", query = "SELECT c FROM CustomerGroup c WHERE c.meetingDate = :meetingDate"),
    @NamedQuery(name = "CustomerGroup.findByBranch", query = "SELECT c FROM CustomerGroup c WHERE c.branch = :branch"),
    @NamedQuery(name = "CustomerGroup.findByPrimaryAddress", query = "SELECT c FROM CustomerGroup c WHERE c.primaryAddress = :primaryAddress"),
    @NamedQuery(name = "CustomerGroup.findByPrimaryContact", query = "SELECT c FROM CustomerGroup c WHERE c.primaryContact = :primaryContact"),
    @NamedQuery(name = "CustomerGroup.findByStatus", query = "SELECT c FROM CustomerGroup c WHERE c.status = :status"),
    @NamedQuery(name = "CustomerGroup.findByAddedBy", query = "SELECT c FROM CustomerGroup c WHERE c.addedBy = :addedBy"),
    @NamedQuery(name = "CustomerGroup.findByAddedDate", query = "SELECT c FROM CustomerGroup c WHERE c.addedDate = :addedDate"),
    @NamedQuery(name = "CustomerGroup.findByModifiedBy", query = "SELECT c FROM CustomerGroup c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CustomerGroup.findByModifiedDate", query = "SELECT c FROM CustomerGroup c WHERE c.modifiedDate = :modifiedDate")})
public class CustomerGroup implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private List<Customer> customerList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "group_id")
    private String groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "group_name")
    private String groupName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_establishment")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfEstablishment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "meeting_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date meetingDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "branch")
    private String branch;
    @Size(max = 255)
    @Column(name = "primary_address")
    private String primaryAddress;
    @Size(max = 255)
    @Column(name = "primary_contact")
    private String primaryContact;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
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
    @JoinColumn(name = "employee", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employee employee;

    public CustomerGroup() {
    }

    public CustomerGroup(String groupId) {
        this.groupId = groupId;
    }

    public CustomerGroup(String groupId, String groupName, Date dateOfEstablishment, Date meetingDate, String branch, String status, String addedBy, Date addedDate, String modifiedBy, Date modifiedDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.dateOfEstablishment = dateOfEstablishment;
        this.meetingDate = meetingDate;
        this.branch = branch;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(Date dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerGroup)) {
            return false;
        }
        CustomerGroup other = (CustomerGroup) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.CustomerGroup[ groupId=" + groupId + " ]";
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
}
