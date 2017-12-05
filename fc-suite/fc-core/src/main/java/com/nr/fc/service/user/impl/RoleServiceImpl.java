
package com.nr.fc.service.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nr.fc.dao.PrivilegeDao;
import com.nr.fc.dao.RoleDao;
import com.nr.fc.dao.RolePrivilegeDao;
import com.nr.fc.dao.UserRoleLinkDao;
import com.nr.fc.enums.GeneralStatus;
import com.nr.fc.model.Privilege;
import com.nr.fc.model.Role;
import com.nr.fc.model.RolePrivilege;
import com.nr.fc.model.RolePrivilegePK;
import com.nr.fc.service.user.RoleService;
import java.text.NumberFormat;
import java.util.Date;

/**
 *
 * @author Amith
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RolePrivilegeDao rolePrivilegeDao;
    @Autowired
    private PrivilegeDao privilegeDao;
    @Autowired
    private UserRoleLinkDao userRoleLinkDao;

    @Transactional
    @Override
    public void save(Role role, List<Privilege> privileges, String userName) throws Exception {
        role.setRoleCode(getLastRoleID());
        roleDao.create(role);
        for (Privilege privilege : privileges) {
            RolePrivilege rolePrivilege = new RolePrivilege();
            rolePrivilege.setAddedBy(userName);
            rolePrivilege.setAddedDate(new Date());
            rolePrivilege.setPrivilege(privilege);
            rolePrivilege.setRole(role);
            rolePrivilege.setRolePrivilegePK(new RolePrivilegePK(role.getRoleCode(), privilege.getPrivilegeName()));
            rolePrivilege.setStatus(GeneralStatus.ACTIVE);
            rolePrivilegeDao.create(rolePrivilege);
        }
    }

    @Transactional
    @Override
    public void update(Role role) throws Exception {
        roleDao.update(role);
    }

    @Transactional
    @Override
    public void delete(Role role) throws Exception {
        roleDao.delete(role);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findByRoleName(String roleName) {
        Role role = new Role();
        String sql = "SELECT a FROM Role a WHERE a.roleName =:roleName AND a.status =:status";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleName", roleName);
        params.put("status", GeneralStatus.ACTIVE);
        role = roleDao.findbyQuerySingle(sql, params);
        return role;
    }

    @Override
    public List<Privilege> findPrivilegesByRoleName(String username) {
        List<Privilege> privileges = new ArrayList<>();
        String sql = "SELECT a.privilege FROM RolePrivilege a WHERE a.role.roleCode IN (SELECT b.role.roleCode FROM UserRoleLink b WHERE b.user.userName =:userName AND b.status =:status) ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", username);
        params.put("status", GeneralStatus.ACTIVE);
        privileges = privilegeDao.findbyQuery(sql, params);
//        for (RolePrivilege rolePrivilege : rolePrivileges) {
//         
//            privileges.add(privilegeDao.read(rolePrivilege.getPrivilege().getPrivilegeName()));
//        }
        return privileges;
    }

    @Override
    public List<Role> findByRoleNameUserTypeANDUserCate(String roleName, String userType, String userCategory) {
        List<Role> roles = new ArrayList<>();
        try {
            String sql = "SELECT a FROM Role a WHERE a.roleName IS NOT NULL ";
            if (roleName != null && !roleName.equals("")) {
                sql += " AND a.roleName LIKE :roleName ";
            }

            if (userType != null && !userType.equals("")) {
                sql += " AND a.userCategory.userCategoryPK.userType =:userType ";
            }

            if (userCategory != null && !userCategory.equals("")) {
                sql += " AND a.userCategory.userCategoryPK.userCategory =:userCategory ";
            }
            Map<String, Object> params = new HashMap<String, Object>();
            if (roleName != null && !roleName.equals("")) {
                params.put("roleName", roleName + "%");
            }
            if (userType != null && !userType.equals("")) {
                params.put("userType", userType);
            }

            if (userCategory != null && !userCategory.equals("")) {
                params.put("userCategory", userCategory);
            }
            roles = roleDao.findbyQuery(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    private String getLastRoleID() {
        String sql = "SELECT a FROM Role a ORDER BY a.roleCode DESC ";
        List<Role> findNamedQueryLimit = roleDao.findbyQuery(sql, new HashMap<String, Object>());

        String prefix = "RO";
        String firstid = "001";
        int index = 0;
        String lastRoleID = null;

        if (!findNamedQueryLimit.isEmpty()) {

            lastRoleID = findNamedQueryLimit.get(0).getRoleCode();

            for (int i = 0; i < lastRoleID.length(); i++) {
                char c = lastRoleID.charAt(i);
                if (Character.isDigit(c)) {
                    index = i;
                    break;
                }
            }
            int newidNumber = Integer.parseInt(lastRoleID.substring(index)) + 1;
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);

            String lastId = prefix + numberFormat.format(newidNumber);
            return lastId;
        } else {
            return prefix + firstid;
        }
    }

    @Override
    public Role findByRoleID(String roleId) {
        return roleDao.read(roleId);
    }

    @Override
    public List<Role> findByUserType(String userType) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT a FROM Role a WHERE a.userCategory.userType.userType =:userType AND a.status =:status";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userType", userType);
        params.put("status", GeneralStatus.ACTIVE);
        roles = roleDao.findbyQuery(sql, params);
        return roles;
    }

    @Override
    public List<Role> findByStatus(String status) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT a FROM Role a WHERE a.status =:status";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", status);
        roles = roleDao.findbyQuery(sql, params);
        return roles;
    }

}
