
package com.nr.fc.json.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Amith
 */
public class ClassIdJson {

    @JsonProperty
    private String classId;
    @JsonProperty
    private String className;
    @JsonProperty
    private String classCategorey;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCategorey() {
        return classCategorey;
    }

    public void setClassCategorey(String classCategorey) {
        this.classCategorey = classCategorey;
    }




}
