
package com.nr.fc.service.user;

import com.nr.fc.model.RolePrivilege;
import java.util.List;

/**
 *
 * @author Madhuranga Samarasinghe
 */
public interface RolePrivilegeService {

    public List<RolePrivilege> findAllByRole(String roleName);
    
}
