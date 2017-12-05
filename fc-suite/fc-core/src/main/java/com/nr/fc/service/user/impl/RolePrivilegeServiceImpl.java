
package com.nr.fc.service.user.impl;

import com.nr.fc.dao.RolePrivilegeDao;
import com.nr.fc.model.RolePrivilege;
import com.nr.fc.service.user.RolePrivilegeService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Madhuranga Samarasinghe
 */
@Service
public class RolePrivilegeServiceImpl implements RolePrivilegeService {

    @Autowired
    private RolePrivilegeDao rolePrivilegeDao;

    @Override
    public List<RolePrivilege> findAllByRole(String roleName) {
        List<RolePrivilege> clubs = new ArrayList<>();
        try {
            String sql = "SELECT a FROM RolePrivilege a WHERE a.role.roleName =:roleName";

            Map<String, Object> params = new HashMap<String, Object>();

            params.put("roleName", roleName);

            return rolePrivilegeDao.findbyQuery(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clubs;
    }

}
