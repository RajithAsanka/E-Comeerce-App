
package com.nr.fc.service.user;

import com.nr.fc.model.UserRoleLink;
import com.nr.fc.model.UserRoleLinkPK;
import java.util.List;

/**
 *
 * @author Rajitha
 */
public interface UserRoleLinkService {

    /**
     *
     * @param userName
     * @return
     */
    public List<UserRoleLink> findByUserName(String userName);

    /**
     *
     * @param roleLinkPK
     * @return
     */
    public UserRoleLink findByPK(UserRoleLinkPK roleLinkPK);

}
