/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.json.model;

import java.util.List;

/**
 *
 * @author Madhuranga Samarasinghe
 */
public class RoleJson {
    private String roleCode;
    private String roleName;
    private String status;
    private String userType;
    private String userCategory;
    private String description;
    private List<PrivilegeJson> privilegeList;
    private String state;

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return the userCategory
     */
    public String getUserCategory() {
        return userCategory;
    }

    /**
     * @param userCategory the userCategory to set
     */
    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    /**
     * @return the privilegeList
     */
    public List<PrivilegeJson> getPrivilegeList() {
        return privilegeList;
    }

    /**
     * @param privilegeList the privilegeList to set
     */
    public void setPrivilegeList(List<PrivilegeJson> privilegeList) {
        this.privilegeList = privilegeList;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the roleCode
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * @param roleCode the roleCode to set
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
    
}
