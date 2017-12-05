
package com.nr.fc.service.user.impl;

import com.nr.fc.dao.UserTypeDao;
import com.nr.fc.model.UserType;
import com.nr.fc.service.user.UserTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Madhuranga Samarasinghe
 */
@Service
public class UserTypeServiceImpl implements UserTypeService{
    
    @Autowired
    private UserTypeDao userTypeDao;

    @Override
    public List<UserType> findAll() {
        return userTypeDao.findAll();
    }

    @Override
    public UserType findById(String userType) {
        return userTypeDao.read(userType);
    }

    @Override
    public void save(UserType userType) {
        userTypeDao.create(userType);
    }

    @Override
    public void update(UserType userType) {
       userTypeDao.update(userType);
    }
    
}
