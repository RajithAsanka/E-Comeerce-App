/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imperia.core;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 *
 * @author Kithmal
 */
public class AbstractRestClient {
    
    protected String targetServiceUrl;

    public AbstractRestClient(String targetServiceUrl) {
        this.targetServiceUrl = targetServiceUrl;
    }

    public ResteasyWebTarget createTarget(final String serviceUrl) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(serviceUrl);
        return target;
    }

    public Invocation.Builder createBuilder(final String serviceUrl) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(serviceUrl);

        return target.request();
    }

    public Response post(final String url, final Entity<?> entity) throws Exception {

        Response response = createTarget(url).request().post(entity);

        if (!isSuccess(response)) {

            throw new Exception("ERROR");
        }
        return response;
    }

    public Response put(final String url, final Entity<?> entity) throws Exception {

        Response response = createTarget(url).request().put(entity);

        if (!isSuccess(response)) {

              throw new Exception("ERROR");
        }
        return response;
    }

    /**
     * Delete entity form given url and parameters
     *
     * @param url WS url path for delete request
     * @param parameters MultivaluedMap that contains the query parameters
     * @return {@link Response}
     * @throws Exception throws when exception occurred in WS side
     */
    public Response delete(final String url, final MultivaluedMap<String, Object> parameters) throws Exception {

        Response response = createTarget(url).queryParams(parameters).request().delete();

        if (!isSuccess(response)) {

             throw new Exception("ERROR");
        }
        return response;
    }

    /**
     * Get the server resource from given url and parameters.
     *
     * @param url Service URL for given resource
     * @param parameters MultivaluedMap with query parameters.
     * @return Response
     * @throws Exception throws if any server exception occurred.
     */
    public Response get(final String url, final MultivaluedMap<String, Object> parameters) throws Exception {

        Response response = createTarget(url).queryParams(parameters).request().get();

        if (!isSuccess(response)) {

             throw new Exception("ERROR");
        }
        return response;
    }

    /**
     * get the server resource form given url
     *
     * @param url URL of the resource
     * @return Response
     * @throws Exception if a server error occurred
     */
    public Response get(final String url) throws Exception {

        Response response = createTarget(url).request().get();
        if (!isSuccess(response)) {

              throw new Exception("ERROR");
        }
        return response;
    }

    /**
     * Check the server response whether success or other failures.
     *
     * @param response Rest server response
     * @return true if server returns 200 as response code
     */
    public boolean isSuccess(final Response response) {
        return response.getStatus() == Response.Status.OK.getStatusCode();
    }

    /**
     * Close the response.
     *
     * @param response Response
     */
    public void close(final Response response) {

        if (response != null) {

            response.close();
        }
    }

    
}
