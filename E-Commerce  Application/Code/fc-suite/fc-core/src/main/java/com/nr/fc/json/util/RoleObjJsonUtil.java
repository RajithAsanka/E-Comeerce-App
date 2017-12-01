/*
 * // *************************************************************************************************
 * //
 * // PROJECT : Fortunaglobal School Management System
 * // PRODUCT : AOD School Management System
 * // ************************************************************************************************
 * //
 * // Copyright(C) 2014 Fortunaglobal (PRIVATE) LIMITED
 * // All rights reserved.
 * //
 * // THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
 * // Fortunaglobal(PRIVATE) LIMITED.
 * //
 * // This copy of the Source Code is intended for Fortunaglobal (PRIVATE) LIMITED 's internal use only
 * // and is
 * // intended for view by persons duly authorized by the management of Fortunaglobal (PRIVATE)
 * // LIMITED. No
 * // part of this file may be reproduced or distributed in any form or by any
 * // means without the written approval of the Management of Fortunaglobal (PRIVATE) LIMITED.
 * //
 * // *************************************************************************************************
 * //
 * // REVISIONS:
 * // Author : user
 * // Date : Jun 21, 2016, 9:37:45 AM
 * // Since : Version 1.0
 * // Description : RoleObjJsonUtil
 */
package com.nr.fc.json.util;

import com.nr.fc.json.model.PrivilegeJson;
import com.nr.fc.json.model.RoleJson;
import com.nr.fc.model.Role;
import com.nr.fc.model.RolePrivilege;
import com.nr.fc.service.user.RolePrivilegeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
@Component
public class RoleObjJsonUtil {

    @Autowired
    private RolePrivilegeService rolePrivilegeService;

    public List<RoleJson> toJson(List<Role> list) {

        List<RoleJson> listReturn = new ArrayList<>();
        for (Role role : list) {

            listReturn.add(toJson(role));
        }
        return listReturn;
    }

    public RoleJson toJson(Role role) {
        RoleJson json = new RoleJson();
        try {
            json.setRoleCode(role.getRoleCode());
            json.setRoleName(role.getRoleName());
            json.setStatus(role.getStatus());
            json.setUserCategory(role.getUserCategory().getUserCategoryPK().getUserCategory());
            json.setUserType(role.getUserCategory().getUserType().getUserType());
            json.setDescription(role.getDescription());
            List<PrivilegeJson> privilegeJsons = new ArrayList<>();
            for (RolePrivilege rolePrivilege : rolePrivilegeService.findAllByRole(role.getRoleName())) {
                PrivilegeJson privilegeJson = new PrivilegeJson();
                privilegeJson.setPrivilegeCode(rolePrivilege.getPrivilege().getPrivilegeCode());
                privilegeJson.setPrivilegeName(rolePrivilege.getPrivilege().getPrivilegeName());
                privilegeJsons.add(privilegeJson);
            }
            json.setPrivilegeList(privilegeJsons);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

}
