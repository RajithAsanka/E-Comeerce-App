package com.nr.fc.common;

import java.util.List;

/**
 * 
 * @author Umaya Windsor
 *
 */
public class ValidationResponse {

	
	private String status;
	private List errorMessageList;
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the errorMessageList
	 */
	public List getErrorMessageList() {
		return errorMessageList;
	}
	/**
	 * @param errorMessageList the errorMessageList to set
	 */
	public void setErrorMessageList(List errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
}
