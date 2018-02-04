package com.imperia.impl;

import com.imperia.CategoryResourceClient;
import com.imperia.requests.CategoryRequest;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

    public List<CategoryRequest> findAll() {

        Client client = Client.create();

        WebResource webResource = client.resource("http://localhost:9090/ecommerce-ws/category-mgt/get-all");
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        List<CategoryRequest> list = new ArrayList<CategoryRequest>();
        list = response.getEntity(new GenericType<List<CategoryRequest>>() {
        });

        return list;

    }

}
