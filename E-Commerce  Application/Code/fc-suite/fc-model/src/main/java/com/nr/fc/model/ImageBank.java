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
@Table(name = "fc_image_bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImageBank.findAll", query = "SELECT i FROM ImageBank i"),
    @NamedQuery(name = "ImageBank.findByImageId", query = "SELECT i FROM ImageBank i WHERE i.imageId = :imageId"),
    @NamedQuery(name = "ImageBank.findByImagePath", query = "SELECT i FROM ImageBank i WHERE i.imagePath = :imagePath"),
    @NamedQuery(name = "ImageBank.findByStatus", query = "SELECT i FROM ImageBank i WHERE i.status = :status"),
    @NamedQuery(name = "ImageBank.findByModifiedDate", query = "SELECT i FROM ImageBank i WHERE i.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "ImageBank.findByModifiedBy", query = "SELECT i FROM ImageBank i WHERE i.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "ImageBank.findByAddedBy", query = "SELECT i FROM ImageBank i WHERE i.addedBy = :addedBy"),
    @NamedQuery(name = "ImageBank.findByAddedDate", query = "SELECT i FROM ImageBank i WHERE i.addedDate = :addedDate")})
public class ImageBank implements Serializable {
    @OneToMany(mappedBy = "imageId")
    private List<Customer> customerList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "image_id")
    private String imageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image_path")
    private String imagePath;
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
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "modified_by")
    private String modifiedBy;
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
    @JoinColumn(name = "image_type_id", referencedColumnName = "image_type_id")
    @ManyToOne(optional = false)
    private ImageType imageTypeId;
    @OneToMany(mappedBy = "imageId")
    private List<Employee> employeeList;

    public ImageBank() {
    }

    public ImageBank(String imageId) {
        this.imageId = imageId;
    }

    public ImageBank(String imageId, String imagePath, String status, Date date, String username) {
        this.imageId = imageId;
        this.imagePath = imagePath;
        this.status = status;
        this.modifiedDate = date;
        this.modifiedBy = username;
        this.addedBy = username;
        this.addedDate = date;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
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

    public ImageType getImageTypeId() {
        return imageTypeId;
    }

    public void setImageTypeId(ImageType imageTypeId) {
        this.imageTypeId = imageTypeId;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageId != null ? imageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImageBank)) {
            return false;
        }
        ImageBank other = (ImageBank) object;
        if ((this.imageId == null && other.imageId != null) || (this.imageId != null && !this.imageId.equals(other.imageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.ImageBank[ imageId=" + imageId + " ]";
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
}
