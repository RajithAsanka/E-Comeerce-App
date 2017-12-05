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
public class EmailEnum {
    public static final String SENT = "Sent";
    public static final String NOT_SENT = "Error";

    /**
     * This function is to help to standardize the General Status
     * Eg. If you insert AcTiVate this will return the correct format with the first letter capital 
     * 	   and other letters simple
     * @param status the binding status should be given here
     * @return "Activate" or "Deactivate"
     */
    public static final String find(String emailStatus){
    	if(emailStatus.equalsIgnoreCase("Sent")||emailStatus.equalsIgnoreCase("Sent")){
			return SENT;
		}else if(emailStatus.equalsIgnoreCase("Error")||emailStatus.equalsIgnoreCase("Error")){
			return NOT_SENT;
		}else{
			return NOT_SENT;
		}
    }
}
