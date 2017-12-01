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
@Table(name = "fc_customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customer.findBySalutaionId", query = "SELECT c FROM Customer c WHERE c.salutaionId = :salutaionId"),
    @NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Customer.findByMiddleName", query = "SELECT c FROM Customer c WHERE c.middleName = :middleName"),
    @NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM Customer c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Customer.findByDateOfBirth", query = "SELECT c FROM Customer c WHERE c.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Customer.findByGender", query = "SELECT c FROM Customer c WHERE c.gender = :gender"),
    @NamedQuery(name = "Customer.findByIdType", query = "SELECT c FROM Customer c WHERE c.idType = :idType"),
    @NamedQuery(name = "Customer.findByCustomerIdentificationNo", query = "SELECT c FROM Customer c WHERE c.customerIdentificationNo = :customerIdentificationNo"),
    @NamedQuery(name = "Customer.findByIssudeCountry", query = "SELECT c FROM Customer c WHERE c.issudeCountry = :issudeCountry"),
    @NamedQuery(name = "Customer.findByOccupation", query = "SELECT c FROM Customer c WHERE c.occupation = :occupation"),
    @NamedQuery(name = "Customer.findByNoOfFamilyMembers", query = "SELECT c FROM Customer c WHERE c.noOfFamilyMembers = :noOfFamilyMembers"),
    @NamedQuery(name = "Customer.findByNoOfDependents", query = "SELECT c FROM Customer c WHERE c.noOfDependents = :noOfDependents"),
    @NamedQuery(name = "Customer.findByFirstAddress", query = "SELECT c FROM Customer c WHERE c.firstAddress = :firstAddress"),
    @NamedQuery(name = "Customer.findBySecondAddress", query = "SELECT c FROM Customer c WHERE c.secondAddress = :secondAddress"),
    @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.city = :city"),
    @NamedQuery(name = "Customer.findByProvince", query = "SELECT c FROM Customer c WHERE c.province = :province"),
    @NamedQuery(name = "Customer.findByModifiedBy", query = "SELECT c FROM Customer c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Customer.findByModifiedDate", query = "SELECT c FROM Customer c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "Customer.findByStatus", query = "SELECT c FROM Customer c WHERE c.status = :status"),
    @NamedQuery(name = "Customer.findByComments", query = "SELECT c FROM Customer c WHERE c.comments = :comments"),
    @NamedQuery(name = "Customer.findByAddedBy", query = "SELECT c FROM Customer c WHERE c.addedBy = :addedBy"),
    @NamedQuery(name = "Customer.findByAddedDate", query = "SELECT c FROM Customer c WHERE c.addedDate = :addedDate")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "customer_id")
    private String customerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "salutaion_id")
    private String salutaionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 100)
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "gender")
    private String gender;
    @Size(max = 100)
    @Column(name = "id_type")
    private String idType;
    @Size(max = 255)
    @Column(name = "customer_identification_no")
    private String customerIdentificationNo;
    @Size(max = 255)
    @Column(name = "issude_country")
    private String issudeCountry;
    @Size(max = 255)
    @Column(name = "occupation")
    private String occupation;
    @Size(max = 2)
    @Column(name = "no_of_family_members")
    private String noOfFamilyMembers;
    @Size(max = 2)
    @Column(name = "no_of_dependents")
    private String noOfDependents;
    @Size(max = 255)
    @Column(name = "first_address")
    private String firstAddress;
    @Size(max = 255)
    @Column(name = "second_address")
    private String secondAddress;
    @Size(max = 255)
    @Column(name = "city")
    private String city;
    @Size(max = 255)
    @Column(name = "province")
    private String province;
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
    @Size(max = 255)
    @Column(name = "comments")
    private String comments;
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
    @JoinColumn(name = "image_id", referencedColumnName = "image_id")
    @ManyToOne
    private ImageBank imageId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false)
    private CustomerGroup groupId;

    public Customer() {
    }

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public Customer(String customerId, String salutaionId, String firstName, String lastName, String gender, String modifiedBy, Date modifiedDate, String status, String addedBy, Date addedDate) {
        this.customerId = customerId;
        this.salutaionId = salutaionId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSalutaionId() {
        return salutaionId;
    }

    public void setSalutaionId(String salutaionId) {
        this.salutaionId = salutaionId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getCustomerIdentificationNo() {
        return customerIdentificationNo;
    }

    public void setCustomerIdentificationNo(String customerIdentificationNo) {
        this.customerIdentificationNo = customerIdentificationNo;
    }

    public String getIssudeCountry() {
        return issudeCountry;
    }

    public void setIssudeCountry(String issudeCountry) {
        this.issudeCountry = issudeCountry;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNoOfFamilyMembers() {
        return noOfFamilyMembers;
    }

    public void setNoOfFamilyMembers(String noOfFamilyMembers) {
        this.noOfFamilyMembers = noOfFamilyMembers;
    }

    public String getNoOfDependents() {
        return noOfDependents;
    }

    public void setNoOfDependents(String noOfDependents) {
        this.noOfDependents = noOfDependents;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public ImageBank getImageId() {
        return imageId;
    }

    public void setImageId(ImageBank imageId) {
        this.imageId = imageId;
    }

    public CustomerGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(CustomerGroup groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.Customer[ customerId=" + customerId + " ]";
    }
    
}
