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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rajith
 */
@Entity
@Table(name = "fc_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByUserType", query = "SELECT u FROM User u WHERE u.userType = :userType"),
    @NamedQuery(name = "User.findByFirstTimeLogin", query = "SELECT u FROM User u WHERE u.firstTimeLogin = :firstTimeLogin"),
    @NamedQuery(name = "User.findByLastLoginTime", query = "SELECT u FROM User u WHERE u.lastLoginTime = :lastLoginTime"),
    @NamedQuery(name = "User.findByApproveMode", query = "SELECT u FROM User u WHERE u.approveMode = :approveMode"),
    @NamedQuery(name = "User.findByModifiedBy", query = "SELECT u FROM User u WHERE u.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "User.findByModifiedDate", query = "SELECT u FROM User u WHERE u.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status"),
    @NamedQuery(name = "User.findByAddedBy", query = "SELECT u FROM User u WHERE u.addedBy = :addedBy"),
    @NamedQuery(name = "User.findByAddedDate", query = "SELECT u FROM User u WHERE u.addedDate = :addedDate")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_type")
    private String userType;
    @Column(name = "first_time_login")
    private Boolean firstTimeLogin;
    @Column(name = "last_login_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "approve_mode")
    private String approveMode;
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
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne
    private Employee employeeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userName")
    private List<UserPasswordAudit> userPasswordAuditList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserRoleLink> userRoleLinkList;

    @Transient
    private List<Privilege> privileges;

    public List<Privilege> getPrivileges() {

        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {

        this.privileges = privileges;
    }

    @Transient
    private String imagePath = "";

    public String getImagePath() {

        if (getEmployeeId() != null) {
            if (getEmployeeId().getImageId() != null && getEmployeeId().getImageId().getImagePath() != null) {
                imagePath = "/employee-image?file=" + getEmployeeId().getImageId().getImagePath();
            }
        }

        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String password, String userType, String approveMode, String modifiedBy, Date modifiedDate, String status, String addedBy, Date addedDate) {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.approveMode = approveMode;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(Boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getApproveMode() {
        return approveMode;
    }

    public void setApproveMode(String approveMode) {
        this.approveMode = approveMode;
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

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @XmlTransient
    public List<UserPasswordAudit> getUserPasswordAuditList() {
        return userPasswordAuditList;
    }

    public void setUserPasswordAuditList(List<UserPasswordAudit> userPasswordAuditList) {
        this.userPasswordAuditList = userPasswordAuditList;
    }

    @XmlTransient
    public List<UserRoleLink> getUserRoleLinkList() {
        return userRoleLinkList;
    }

    public void setUserRoleLinkList(List<UserRoleLink> userRoleLinkList) {
        this.userRoleLinkList = userRoleLinkList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nr.fc.model.User[ userName=" + userName + " ]";
    }

}
