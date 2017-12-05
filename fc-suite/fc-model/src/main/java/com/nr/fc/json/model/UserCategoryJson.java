/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.json.model;

/**
 *
 * @author Madhuranga Samarasinghe
 */
public class UserCategoryJson {
    private String userCategory;
    private String userType;
    private String decription;
    private String status;

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
     * @return the decription
     */
    public String getDecription() {
        return decription;
    }

    /**
     * @param decription the decription to set
     */
    public void setDecription(String decription) {
        this.decription = decription;
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
}
