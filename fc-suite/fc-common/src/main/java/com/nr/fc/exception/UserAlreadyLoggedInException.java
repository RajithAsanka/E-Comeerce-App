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
public class UserAlreadyLoggedInException extends BussinessException {
    /* serial version unique id. */

    private static final long serialVersionUID = 2818768778989208803L;

    /**
     * This is constructor uses to build the object with error code and error
     * arguments.
     *
     * @param errorCode error code to get locale specific error message.
     * @param userName user name for which error occurred.
     */
    public UserAlreadyLoggedInException(final String errorCode, final String userName) {

        super(errorCode, userName);
    }

    /**
     * This constructor uses to build the object with final error message(Locale
     * specific and formatted string).
     *
     * @param message error message with description.
     */
    public UserAlreadyLoggedInException(final String message) {

        super(message);
    }
}
