/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.json.model;

/**
 *
 * @author Mohamed Sayyaff
 */
public class PrivilegeJson {
    /**
     *  Privilegecode property
     */
    private String privilegeCode;
    /**
     *  checked property
     */
    private boolean checked;
    /**
     * privilegeName property
     */
    private String privilegeName;
    
    
    public String getPrivilegeName() {
    
      return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
    
      this.privilegeName = privilegeName;
    }

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
