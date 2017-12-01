/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.enums;

/**
 *
 * @author Madhuranga Samarasinghe
 */
public class UserTypes {
    public static final String STUDENT = "Student";
    public static final String PARENT = "Parent";
    public static final String EMPLOYEE = "Employee";
    public static final String ADMIN = "Admin";

    /**
     * This function is to help to standardize the General Status
     * Eg. If you insert AcTiVate this will return the correct format with the first letter capital 
     * 	   and other letters simple
     * @param status the binding status should be given here
     * @return "Activate" or "Deactivate"
     */
    public static final String find(String status){
    	if(status.equalsIgnoreCase("Student")||status.equalsIgnoreCase("Student")){
			return STUDENT;
		}else if(status.equalsIgnoreCase("Parent")||status.equalsIgnoreCase("Parent")){
			return PARENT;
		}else if(status.equalsIgnoreCase("Employee")||status.equalsIgnoreCase("Employee")){
			return EMPLOYEE;
		}else{
			return ADMIN;
		}
    }
}
