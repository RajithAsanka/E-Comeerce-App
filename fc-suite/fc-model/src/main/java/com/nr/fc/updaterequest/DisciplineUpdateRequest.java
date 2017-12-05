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
public class DisciplineUpdateRequest {

    @JsonProperty
    private String disciplinereferenceid;
    @JsonProperty
    private String programId;
    @JsonProperty
    private String batchId;
    @JsonProperty
    private String classId;
    @JsonProperty
    private String studentRefno;
    @JsonProperty
    private String warnings;
    @JsonProperty
    private String comments;
    @JsonProperty
    private String complainBy;
    @JsonProperty
    private String juryList;
    @JsonProperty
    private String actionsList;
    @JsonProperty
    private String username;

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
     * @return the studentRefno
     */
    public String getStudentRefno() {
        return studentRefno;
    }

    /**
     * @param studentRefno the studentRefno to set
     */
    public void setStudentRefno(String studentRefno) {
        this.studentRefno = studentRefno;
    }

    /**
     * @return the warnings
     */
    public String getWarnings() {
        return warnings;
    }

    /**
     * @param warnings the warnings to set
     */
    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the complainBy
     */
    public String getComplainBy() {
        return complainBy;
    }

    /**
     * @param complainBy the complainBy to set
     */
    public void setComplainBy(String complainBy) {
        this.complainBy = complainBy;
    }

    /**
     * @return the juryList
     */
    public String getJuryList() {
        return juryList;
    }

    /**
     * @param juryList the juryList to set
     */
    public void setJuryList(String juryList) {
        this.juryList = juryList;
    }

    /**
     * @return the actionsList
     */
    public String getActionsList() {
        return actionsList;
    }

    /**
     * @param actionsList the actionsList to set
     */
    public void setActionsList(String actionsList) {
        this.actionsList = actionsList;
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

    /**
     * @return the disciplinereferenceid
     */
    public String getDisciplinereferenceid() {
        return disciplinereferenceid;
    }

    /**
     * @param disciplinereferenceid the disciplinereferenceid to set
     */
    public void setDisciplinereferenceid(String disciplinereferenceid) {
        this.disciplinereferenceid = disciplinereferenceid;
    }

}
