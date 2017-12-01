
package com.nr.fc.service.user;

import com.nr.fc.model.UserCategory;
import com.nr.fc.model.UserCategoryPK;
import java.util.List;

/**
 *
 * @author Madhuranga Samarasinghe
 */
public interface UserCategoryService {

    public List<UserCategory> findAll();

    public UserCategory findById(UserCategoryPK userCategoryPK);

    public void save(UserCategory userCategory1);

    public void update(UserCategory userCategory1);

    public List<UserCategory> findByUserType(String userType);
    
}
