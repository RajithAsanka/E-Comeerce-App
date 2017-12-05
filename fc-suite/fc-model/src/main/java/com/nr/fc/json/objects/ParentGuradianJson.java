
package com.nr.fc.json.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Amith
 */
public class ParentGuradianJson {

    @JsonProperty
    private String parentGuardianId;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String middleName;

    public String getParentGuardianId() {
        return parentGuardianId;
    }

    public void setParentGuardianId(String parentGuardianId) {
        this.parentGuardianId = parentGuardianId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

}
