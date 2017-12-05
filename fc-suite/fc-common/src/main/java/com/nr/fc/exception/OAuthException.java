/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.exception;

/**
 *
 * @author user
 */
public class OAuthException extends BussinessException {

    /* serial version unique id. */
    private static final long serialVersionUID = -6838747536623800881L;

    /**
     * This is constructor uses to create a OAuth exception with error messages.
     *
     * @param message error message with description.
     */
    public OAuthException(final String message) {

        super(message);
    }

}
