
package com.nr.fc.service.user.impl;

import com.nr.fc.dao.UserRoleLinkDao;
import com.nr.fc.model.UserRoleLink;
import com.nr.fc.model.UserRoleLinkPK;
import com.nr.fc.service.user.UserRoleLinkService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rajitha
 */
@Service
public class UserRoleLinkServiceImpl implements UserRoleLinkService {

    @Autowired
    private UserRoleLinkDao userRoleLinkDao;

    @Override
    public List<UserRoleLink> findByUserName(String userName) {

        String sql = "SELECT a FROM UserRoleLink a WHERE a.userRoleLinkPK.userName = :userName ";
        sql += " AND a.status = 'Active'";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        return userRoleLinkDao.findbyQuery(sql, params);

    }

    @Override
    public UserRoleLink findByPK(UserRoleLinkPK roleLinkPK) {
        return userRoleLinkDao.read(roleLinkPK);
    }

}
