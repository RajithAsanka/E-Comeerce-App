
package com.nr.fc.json.options;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Amith
 */
public class SelectOption implements Serializable {

    private Object value;
    private String displayText;

    public SelectOption(Object value, String displayText) {
        this.value = value;
        this.displayText = displayText;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.value);
        hash = 53 * hash + Objects.hashCode(this.displayText);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SelectOption other = (SelectOption) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        if (!Objects.equals(this.displayText, other.displayText)) {
            return false;
        }
        return true;
    }

   
    
    

}
