package com.imperia.impl;

import com.imperia.UserResourceClient;
import com.imperia.core.AbstractRestClient;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;

/**
 * Created by Kithmal on 12/5/17.
 */
public class UserResourceClientImpl extends AbstractRestClient implements UserResourceClient {

    public UserResourceClientImpl(String targetServiceUrl) {
        super(targetServiceUrl);
    }

    public String getUser() {

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

    }
    
    
    
}
