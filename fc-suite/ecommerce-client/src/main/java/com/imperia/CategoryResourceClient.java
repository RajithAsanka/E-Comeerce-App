package com.imperia;

import com.nr.fc.request.CategoryRequest;

import javax.ws.rs.core.Response;

/**
 * Category Resource Client
 * Created by Kithmal on 12/11/17.
 */
public interface CategoryResourceClient {

    CategoryRequest saveCateogry(CategoryRequest categoryRequest);
}
