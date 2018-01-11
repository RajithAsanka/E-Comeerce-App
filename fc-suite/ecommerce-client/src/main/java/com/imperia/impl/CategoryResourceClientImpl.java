package com.imperia.impl;

import com.imperia.CategoryResourceClient;
import com.imperia.requests.CategoryRequest;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Kithmal on 12/11/17.
 */
public class CategoryResourceClientImpl implements CategoryResourceClient {

    public CategoryRequest saveCateogry(CategoryRequest request) {

        Client client = Client.create();

        WebResource webResource = client.resource("http://localhost:9090/ecommerce-ws/category-mgt/save");
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, request);

        if (response.getStatus() == 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        System.out.println("Output from Server .... \n");

        /**
         * Retriev the response from the WS*
         */
        CategoryRequest output = response.getEntity(CategoryRequest.class);

        return output;
    }

    /**
     * public CategoryResourceClientImpl(String targetServiceUrl) {
     * super(targetServiceUrl); }
     *
     *
     * public CategoryRequest saveCateogry(CategoryRequest categoryRequest) {
     *
     * Response response = null; Entity<CategoryRequest> entity =
     * Entity.entity(categoryRequest, MediaType.APPLICATION_JSON_TYPE); try {
     *
     * response = super.post(this.targetServiceUrl + "/save", entity);
     * CategoryRequest ftResponse = response.readEntity(CategoryRequest.class);
     * return ftResponse; } catch (Exception e) {
     *
     * throw new InternalServerErrorException(e); } finally {
     *
     * close(response); } }
     *
     */
}
