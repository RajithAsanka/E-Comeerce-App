/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.saverequest;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author user
 */
public class HolidaySaveRequest {

    @JsonProperty
    private String holidayCategory;
    @JsonProperty
    private String startDate;
    @JsonProperty
    private String endDate;
    @JsonProperty
    private String description;
    @JsonProperty
    private String color;
    @JsonProperty
    private String status;
    @JsonProperty
    private String userName;

    /**
     * @return the holidayCategory
     */
    public String getHolidayCategory() {
        return holidayCategory;
    }

    /**
     * @param holidayCategory the holidayCategory to set
     */
    public void setHolidayCategory(String holidayCategory) {
        this.holidayCategory = holidayCategory;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
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
