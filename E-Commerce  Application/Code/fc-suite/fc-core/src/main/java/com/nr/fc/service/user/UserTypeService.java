
package com.nr.fc.service.user;

import com.nr.fc.model.UserType;
import java.util.List;

/**
 *
 * @author Madhuranga Samarasinghe
 */
public interface UserTypeService {
    
    public List<UserType> findAll();
    
    public UserType findById(String UserType);
    
    public void save(UserType userType);
    
    public void update(UserType userType);
    
}
