package com.imperia.impl;

import com.imperia.CategoryResourceClient;
import com.imperia.core.AbstractRestClient;
import com.nr.fc.request.CategoryRequest;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Kithmal on 12/11/17.
 */
public class CategoryResourceClientImpl extends AbstractRestClient implements CategoryResourceClient {

    public CategoryResourceClientImpl(String targetServiceUrl) {
        super(targetServiceUrl);
    }

    public CategoryRequest saveCateogry(CategoryRequest categoryRequest) {

        Response response = null;
        Entity<CategoryRequest> entity = Entity.entity(categoryRequest, MediaType.APPLICATION_JSON_TYPE);
        try {

            response = super.post(this.targetServiceUrl + "/save", entity);
            CategoryRequest ftResponse = response.readEntity(CategoryRequest.class);
            return ftResponse;
        } catch (Exception e) {

            throw new InternalServerErrorException(e);
        } finally {

            close(response);
        }
    }
}
