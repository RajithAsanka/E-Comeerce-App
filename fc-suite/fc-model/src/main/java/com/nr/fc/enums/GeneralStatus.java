
package com.nr.fc.enums;

/**
 *
 * @author Amith
 */
public class GeneralStatus {

    public static final String ACTIVE = "Active";
    public static final String DEACTIVE = "Deactive";
    public static final String APPROVED = "Approved";

    /**
     * This function is to help to standardize the General Status
     * Eg. If you insert AcTiVate this will return the correct format with the first letter capital 
     * 	   and other letters simple
     * @param status the binding status should be given here
     * @return "Activate" or "Deactivate"
     */
    public static final String find(String status){
    	if(status.equalsIgnoreCase("Activate")||status.equalsIgnoreCase("Active")){
			return ACTIVE;
		}else if(status.equalsIgnoreCase("deactivate")||status.equalsIgnoreCase("deactive")){
			return DEACTIVE;
		}else{
			return DEACTIVE;
		}
    }
}
