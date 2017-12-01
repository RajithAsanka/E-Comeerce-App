/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.updaterequest;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author user
 */
public class EventUpdateRequest {

    @JsonProperty
    private String eventName;
    @JsonProperty
    private String eventType;
    @JsonProperty
    private String eventStartDate;
    @JsonProperty
    private String eventEndDate;
    @JsonProperty
    private String eventAlertDate;
    @JsonProperty
    private String description;
    @JsonProperty
    private String status;
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
     * @return the eventStartDate
     */
    public String getEventStartDate() {
        return eventStartDate;
    }

    /**
     * @param eventStartDate the eventStartDate to set
     */
    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    /**
     * @return the eventEndDate
     */
    public String getEventEndDate() {
        return eventEndDate;
    }

    /**
     * @param eventEndDate the eventEndDate to set
     */
    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    /**
     * @return the eventAlertDate
     */
    public String getEventAlertDate() {
        return eventAlertDate;
    }

    /**
     * @param eventAlertDate the eventAlertDate to set
     */
    public void setEventAlertDate(String eventAlertDate) {
        this.eventAlertDate = eventAlertDate;
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
