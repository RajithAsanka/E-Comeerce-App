package com.imperia.impl;

import com.imperia.UserResourceClient;


/**
 * Created by Kithmal on 12/5/17.
 */
public class UserResourceClientImpl implements UserResourceClient {

    public String getUser() {

        /**
        Response response = null;
        MultivaluedHashMap<String, Object> parameters = new MultivaluedHashMap<String, Object>() {
        };
        parameters.add("username", "Kithmal");
        parameters.add("password", "123");

        try {
            response = super.get(this.targetServiceUrl + "/save", parameters);
            return response.readEntity(String .class);
        } catch (Exception e) {
            System.out.println("Test" + e);
            throw new InternalServerErrorException(e);
        } finally {
            close(response);
        }
         **/

        return null;

    }
    
    
    
}
