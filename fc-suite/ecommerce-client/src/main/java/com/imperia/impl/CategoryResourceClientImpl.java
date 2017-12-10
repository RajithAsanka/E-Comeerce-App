package com.imperia.impl;

import com.imperia.CategoryResourceClient;
import com.imperia.core.AbstractRestClient;

import javax.ws.rs.core.Response;

/**
 * Created by Kithmal on 12/11/17.
 */
public class CategoryResourceClientImpl extends AbstractRestClient implements CategoryResourceClient {

    public CategoryResourceClientImpl(String targetServiceUrl) {
        super(targetServiceUrl);
    }

    public Response saveCateogry() {
        return null;
    }
}
