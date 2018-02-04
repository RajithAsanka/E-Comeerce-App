package com.imperia;

import com.imperia.requests.CategoryRequest;
import java.util.List;

/**
 * Category Resource Client
 * Created by Kithmal on 12/11/17.
 */
public interface CategoryResourceClient {

    CategoryRequest saveCateogry(CategoryRequest categoryRequest);
    
   List< CategoryRequest> findAll();
    
    
}
