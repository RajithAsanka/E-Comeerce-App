/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 *
 * @author user
 */
public class TimeTableSearchRequest implements Serializable {

    @JsonProperty
    private String course;
    @JsonProperty
    private String batch;
    @JsonProperty
    private String classid;

    /**
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    /**
     * @param cource the course to set
     */
    public void setCourse(String cource) {
        this.course = cource;
    }

    /**
     * @return the batch
     */
    public String getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * @return the classid
     */
    public String getClassid() {
        return classid;
    }

    /**
     * @param classid the classid to set
     */
    public void setClassid(String classid) {
        this.classid = classid;
    }
}
