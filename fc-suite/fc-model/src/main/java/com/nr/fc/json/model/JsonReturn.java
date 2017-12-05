/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nr.fc.json.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amith Fernando
 */
@XmlRootElement
public class JsonReturn {

    
    private String success;
    private String errorCode;
    private String errorMessage;
    private Object result;
    public enum successValue{SUCCESS,FAILED};

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
    
    /**
     * this automatically create true/false string and set it to success
     * @param success : SUCCESS/FAILED
     */
    public void setSuccess(successValue success) {
    	if(success== successValue.SUCCESS)
    		this.success = "true";
    	else if(success== successValue.FAILED)
    		this.success="false";
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
    
    
}
