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
public class AttendanceUpdateRequest {

    @JsonProperty
    private String programName;
    @JsonProperty
    private String batchName;
    @JsonProperty
    private String selectDate;
    @JsonProperty
    private String attendanceMarkTime;
    @JsonProperty
    private String timeTableId;
    @JsonProperty
    private String studentdetailsList;
    @JsonProperty
    private String classId;
    @JsonProperty
    private String day;
    @JsonProperty
    private String username;

    /**
     * @return the programName
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * @param programName the programName to set
     */
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    /**
     * @return the batchName
     */
    public String getBatchName() {
        return batchName;
    }

    /**
     * @param batchName the batchName to set
     */
    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    /**
     * @return the selectDate
     */
    public String getSelectDate() {
        return selectDate;
    }

    /**
     * @param selectDate the selectDate to set
     */
    public void setSelectDate(String selectDate) {
        this.selectDate = selectDate;
    }

    /**
     * @return the attendanceMarkTime
     */
    public String getAttendanceMarkTime() {
        return attendanceMarkTime;
    }

    /**
     * @param attendanceMarkTime the attendanceMarkTime to set
     */
    public void setAttendanceMarkTime(String attendanceMarkTime) {
        this.attendanceMarkTime = attendanceMarkTime;
    }

    /**
     * @return the timeTableId
     */
    public String getTimeTableId() {
        return timeTableId;
    }

    /**
     * @param timeTableId the timeTableId to set
     */
    public void setTimeTableId(String timeTableId) {
        this.timeTableId = timeTableId;
    }

    /**
     * @return the studentdetailsList
     */
    public String getStudentdetailsList() {
        return studentdetailsList;
    }

    /**
     * @param studentdetailsList the studentdetailsList to set
     */
    public void setStudentdetailsList(String studentdetailsList) {
        this.studentdetailsList = studentdetailsList;
    }

    /**
     * @return the classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * @param classId the classId to set
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
