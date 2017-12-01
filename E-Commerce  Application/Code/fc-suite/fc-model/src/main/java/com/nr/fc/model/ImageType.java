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
@Table(name = "fc_image_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImageType.findAll", query = "SELECT i FROM ImageType i"),
    @NamedQuery(name = "ImageType.findByImageTypeId", query = "SELECT i FROM ImageType i WHERE i.imageTypeId = :imageTypeId"),
    @NamedQuery(name = "ImageType.findByStatus", query = "SELECT i FROM ImageType i WHERE i.status = :status"),
    @NamedQuery(name = "ImageType.findByModifiedDate", query = "SELECT i FROM ImageType i WHERE i.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "ImageType.findByModifiedBy", query = "SELECT i FROM ImageType i WHERE i.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "ImageType.findByAddedBy", query = "SELECT i FROM ImageType i WHERE i.addedBy = :addedBy"),
    @NamedQuery(name = "ImageType.findByAddedDate", query = "SELECT i FROM ImageType i WHERE i.addedDate = :addedDate")})
public class ImageType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "image_type_id")
    private String imageTypeId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageTypeId")
    private List<ImageBank> imageBankList;

    public ImageType() {
    }

    public ImageType(String imageTypeId) {
        this.imageTypeId = imageTypeId;
    }

    public ImageType(String imageTypeId, String status, Date modifiedDate, String modifiedBy, String addedBy, Date addedDate) {
        this.imageTypeId = imageTypeId;
        this.status = status;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
    }

    public String getImageTypeId() {
        return imageTypeId;
    }

    public void setImageTypeId(String imageTypeId) {
        this.imageTypeId = imageTypeId;
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

    @XmlTransient
    public List<ImageBank> getImageBankList() {
        return imageBankList;
    }

    public void setImageBankList(List<ImageBank> imageBankList) {
        this.imageBankList = imageBankList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageTypeId != null ? imageTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImageType)) {
            return false;
        }
        ImageType other = (ImageType) object;
        if ((this.imageTypeId == null && other.imageTypeId != null) || (this.imageTypeId != null && !this.imageTypeId.equals(other.imageTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.ImageType[ imageTypeId=" + imageTypeId + " ]";
    }
    
}
