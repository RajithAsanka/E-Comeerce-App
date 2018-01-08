/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imperia.requests;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rajith
 */
@XmlRootElement
public class CategoryRequest implements Serializable {

    private String mainCategory;
    private String categoryName;
    private String status;
    private String description;
    private String userName;

    /**
     * @return the mainCategory
     */
    public String getMainCategory() {
        return mainCategory;
    }

    /**
     * @param mainCategory the mainCategory to set
     */
    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
