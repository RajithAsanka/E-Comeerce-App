/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.properties;

/**
 *
 * @author Madhuranga Samarasinghe
 */
public class EmailProperty {
    
    private String toAddresses;
    private String bccAddresses;
    private String ccAddresses;
    private String subject;
    private String body;

    /**
     * @return the toAddresses
     */
    public String getToAddresses() {
        return toAddresses;
    }

    /**
     * @param toAddresses the toAddresses to set
     */
    public void setToAddresses(String toAddresses) {
        this.toAddresses = toAddresses;
    }

    /**
     * @return the bccAddresses
     */
    public String getBccAddresses() {
        return bccAddresses;
    }

    /**
     * @param bccAddresses the bccAddresses to set
     */
    public void setBccAddresses(String bccAddresses) {
        this.bccAddresses = bccAddresses;
    }

    /**
     * @return the ccAddresses
     */
    public String getCcAddresses() {
        return ccAddresses;
    }

    /**
     * @param ccAddresses the ccAddresses to set
     */
    public void setCcAddresses(String ccAddresses) {
        this.ccAddresses = ccAddresses;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }
    
    
}
