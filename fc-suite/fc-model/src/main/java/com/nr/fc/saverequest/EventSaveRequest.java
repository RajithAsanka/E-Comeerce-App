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
public class EventSaveRequest {

    @JsonProperty
    private String eventName;
    @JsonProperty
    private String eventType;
    @JsonProperty
    private String eventStart;
    @JsonProperty
    private String eventEnd;
    @JsonProperty
    private String alertStart;
    @JsonProperty
    private String description;
    @JsonProperty
    private String status;
    @JsonProperty
    private String commonToAll;
    @JsonProperty
    private String studentSelected;
    @JsonProperty
    private String parentSelected;
    @JsonProperty
    private String employeeSelected;
    @JsonProperty
    private String classList;
    @JsonProperty
    private String departmentList;
    @JsonProperty
    private String userName;

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the eventType
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * @param eventType the eventType to set
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * @return the eventStart
     */
    public String getEventStart() {
        return eventStart;
    }

    /**
     * @param eventStart the eventStart to set
     */
    public void setEventStart(String eventStart) {
        this.eventStart = eventStart;
    }

    /**
     * @return the eventEnd
     */
    public String getEventEnd() {
        return eventEnd;
    }

    /**
     * @param eventEnd the eventEnd to set
     */
    public void setEventEnd(String eventEnd) {
        this.eventEnd = eventEnd;
    }

    /**
     * @return the alertStart
     */
    public String getAlertStart() {
        return alertStart;
    }

    /**
     * @param alertStart the alertStart to set
     */
    public void setAlertStart(String alertStart) {
        this.alertStart = alertStart;
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
     * @return the commonToAll
     */
    public String getCommonToAll() {
        return commonToAll;
    }

    /**
     * @param commonToAll the commonToAll to set
     */
    public void setCommonToAll(String commonToAll) {
        this.commonToAll = commonToAll;
    }

    /**
     * @return the studentSelected
     */
    public String getStudentSelected() {
        return studentSelected;
    }

    /**
     * @param studentSelected the studentSelected to set
     */
    public void setStudentSelected(String studentSelected) {
        this.studentSelected = studentSelected;
    }

    /**
     * @return the parentSelected
     */
    public String getParentSelected() {
        return parentSelected;
    }

    /**
     * @param parentSelected the parentSelected to set
     */
    public void setParentSelected(String parentSelected) {
        this.parentSelected = parentSelected;
    }

    /**
     * @return the employeeSelected
     */
    public String getEmployeeSelected() {
        return employeeSelected;
    }

    /**
     * @param employeeSelected the employeeSelected to set
     */
    public void setEmployeeSelected(String employeeSelected) {
        this.employeeSelected = employeeSelected;
    }

    /**
     * @return the classList
     */
    public String getClassList() {
        return classList;
    }

    /**
     * @param classList the classList to set
     */
    public void setClassList(String classList) {
        this.classList = classList;
    }

    /**
     * @return the departmentList
     */
    public String getDepartmentList() {
        return departmentList;
    }

    /**
     * @param departmentList the departmentList to set
     */
    public void setDepartmentList(String departmentList) {
        this.departmentList = departmentList;
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
