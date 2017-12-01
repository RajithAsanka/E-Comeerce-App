/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author user
 */
public class AttendanceSearchRequest {

    @JsonProperty
    private String programId;
    @JsonProperty
    private String batchId;
    @JsonProperty
    private String levelId;
    @JsonProperty
    private String durationStart;
    @JsonProperty
    private String durationEnd;

    /**
     * @return the programId
     */
    public String getProgramId() {
        return programId;
    }

    /**
     * @param programId the programId to set
     */
    public void setProgramId(String programId) {
        this.programId = programId;
    }

    /**
     * @return the batchId
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the batchId to set
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    /**
     * @return the levelId
     */
    public String getLevelId() {
        return levelId;
    }

    /**
     * @param levelId the levelId to set
     */
    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    /**
     * @return the durationStart
     */
    public String getDurationStart() {
        return durationStart;
    }

    /**
     * @param durationStart the durationStart to set
     */
    public void setDurationStart(String durationStart) {
        this.durationStart = durationStart;
    }

    /**
     * @return the durationEnd
     */
    public String getDurationEnd() {
        return durationEnd;
    }

    /**
     * @param durationEnd the durationEnd to set
     */
    public void setDurationEnd(String durationEnd) {
        this.durationEnd = durationEnd;
    }
}
