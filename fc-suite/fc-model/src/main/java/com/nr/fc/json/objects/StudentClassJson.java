/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.json.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Naveendra
 */
public class StudentClassJson {

    @JsonProperty
    private String studentId;
    @JsonProperty
    private String studentName;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String className) {
        this.studentName = className;
    }

}
