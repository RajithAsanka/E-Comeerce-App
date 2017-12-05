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
public class MassageAlertTypes {
     public static final String CUSTOM = "Custom";
    public static final String EVENT = "Event";
    public static final String ATTENDENCE = "Attendence";

    /**
     * This function is to help to standardize the General Status
     * Eg. If you insert AcTiVate this will return the correct format with the first letter capital 
     * 	   and other letters simple
     * @param status the binding status should be given here
     * @return "Activate" or "Deactivate"
     */
    public static final String find(String status){
    	if(status.equalsIgnoreCase("Custom")||status.equalsIgnoreCase("Custom")){
			return CUSTOM;
		}else if(status.equalsIgnoreCase("Event")||status.equalsIgnoreCase("Event")){
			return EVENT;
		}else if(status.equalsIgnoreCase("Attendence")||status.equalsIgnoreCase("Attende")){
			return ATTENDENCE;
		}else{
			return CUSTOM;
		}
    }
}
