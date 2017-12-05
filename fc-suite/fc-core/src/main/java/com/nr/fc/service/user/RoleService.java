
package com.nr.fc.service.user;

import java.util.List;

import com.nr.fc.model.Privilege;
import com.nr.fc.model.Role;

// TODO: Auto-generated Javadoc
/**
 * The Interface RoleService.
 *
 * @author Amith
 */
public interface RoleService {

    /**
     * Save.
     *
     * @param role the role
     * @param privileges the privileges
     * @throws Exception the exception
     */
    public void save(Role role,List<Privilege> privileges,String userName) throws Exception;

    /**
     * Update.
     *
     * @param role the role
     * @param privileges the privileges
     * @throws Exception the exception
     */
    public void update(Role role) throws Exception;

    /**
     * Delete.
     *
     * @param role the role
     * @throws Exception the exception
     */
    public void delete(Role role) throws Exception;

    /**
     * Find all.
     *
     * @return the list
     */
    public List<Role> findAll();

    /**
     * Find by role name.
     *
     * @param roleName the role name
     * @return the role
     */
    public Role findByRoleName(String roleName);
    
    /**
     * Find privileges by role name.
     *
     * @param roleName the role name
     * @return the list
     */
    public List<Privilege> findPrivilegesByRoleName(String username);

    public List<Role> findByRoleNameUserTypeANDUserCate(String roleName, String userType, String userCategory);

    public Role findByRoleID(String roleId);

    public List<Role> findByUserType(String userType);

    public List<Role> findByStatus(String ACTIVE);

  
}
