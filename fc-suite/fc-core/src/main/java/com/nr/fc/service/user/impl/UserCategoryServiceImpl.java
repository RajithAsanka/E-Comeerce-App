
package com.nr.fc.service.user.impl;

import com.nr.fc.dao.UserCategoryDao;
import com.nr.fc.model.UserCategory;
import com.nr.fc.model.UserCategoryPK;
import com.nr.fc.service.user.UserCategoryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhuranga Samarasinghe
 */
@Service
public class UserCategoryServiceImpl implements UserCategoryService{
    
    @Autowired
    private UserCategoryDao userCategoryDao;

    @Override
    public List<UserCategory> findAll() {
        return userCategoryDao.findAll();
    }

    @Override
    public UserCategory findById(UserCategoryPK userCategoryPK) {
        return userCategoryDao.read(userCategoryPK);
    }

    @Override
    @Transactional
    public void save(UserCategory userCategory1) {
        userCategoryDao.create(userCategory1);
    }

    @Override
    @Transactional
    public void update(UserCategory userCategory1) {
        userCategoryDao.update(userCategory1);
    }

    @Override
    public List<UserCategory> findByUserType(String userType) {
       String sql = "SELECT a FROM UserCategory a WHERE a.userType.userType = :userType ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userType", userType);
        return userCategoryDao.findbyQuery(sql, params);
    }
    
    
    
}
