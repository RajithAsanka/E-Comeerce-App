package com.nr.fc.controller.usermanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nr.fc.common.JsonConverter;
import com.nr.fc.controller.ServicePath;
import com.nr.fc.enums.GeneralStatus;
import com.nr.fc.enums.UserTypes;
import com.nr.fc.exception.BussinessException;
import com.nr.fc.json.model.JsonReturn;
import com.nr.fc.json.model.PrivilegeJson;
import com.nr.fc.json.model.RoleJson;
import com.nr.fc.model.Privilege;
import com.nr.fc.model.Role;
import com.nr.fc.model.RolePrivilege;
import com.nr.fc.model.UserCategory;
import com.nr.fc.model.UserCategoryPK;
import com.nr.fc.model.UserRoleLink;
import com.nr.fc.service.user.PrivilegeService;
import com.nr.fc.service.user.RolePrivilegeService;
import com.nr.fc.service.user.RoleService;
import com.nr.fc.service.user.UserCategoryService;
import com.nr.fc.service.user.UserRoleLinkService;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value = ServicePath.ADMIN_PREFIX + ServicePath.ROLE)
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private JsonConverter jsonConverter;

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private UserCategoryService userCategoryService;

    @Autowired
    private RolePrivilegeService rolePrivilegeService;

    @Autowired
    private UserRoleLinkService userRoleLinkService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn saveRole(@RequestParam(value = "userType", required = true) String userType,
            @RequestParam(value = "userCategory", required = true) String userCategory,
            @RequestParam(value = "roleName", required = true) String roleName,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "privileges", required = true) String privilageList,
            @RequestParam(value = "username", required = true) String username) {

        Role role = new Role();
        JsonReturn jsonReturn = new JsonReturn();
        try {
            role = roleService.findByRoleName(roleName);
            if (role != null) {
                throw new BussinessException("already have user role");
            }

            UserCategory userCategory1 = userCategoryService.findById(new UserCategoryPK(userCategory, userType));
            if (userCategory1 == null) {
                throw new BussinessException("not existing user category");
            }

            role = new Role();
            role.setAddedBy(username);
            role.setAddedDate(new Date());
            role.setDescription(description);
            role.setModifiedBy(username);
            role.setModifiedDate(new Date());
            role.setRoleName(roleName);
            role.setStatus(GeneralStatus.find(status));
            role.setUserCategory(userCategory1);

            List<Privilege> list = jsonConverter.convertPrivilege(privilageList);
            roleService.save(role, list, username);

            jsonReturn.setSuccess("true");
            jsonReturn.setResult(role.getRoleName());

        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> obj2 : e.getConstraintViolations()) {
                System.out.println(obj2.getRootBeanClass().getName());
                System.out.println(obj2.getPropertyPath());
                System.out.println(obj2.getInvalidValue());
                System.out.println(obj2.getConstraintDescriptor());
                System.out.println(obj2.getMessage());
            }
            LOGGER.warn("institueConstraintViolation()", e);
            e.printStackTrace();
        } catch (BussinessException e) {

            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMsg());
            jsonReturn.setErrorCode("123");
            LOGGER.error("saveRole(name)", e);
            e.printStackTrace();

        } catch (Exception e) {
            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMessage());
            jsonReturn.setErrorCode("123");
            LOGGER.error("saveRole()", e);
            e.printStackTrace();
        }
        return jsonReturn;
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public RoleJson findByRoleName(@RequestParam(value = "roleId", required = true) String roleId) {
        return this.toJson(roleService.findByRoleID(roleId));
    }

    @RequestMapping(value = "/getAllPrivilege", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<PrivilegeJson> findByPrivilege() {

        List<PrivilegeJson> list = new ArrayList<>();

        for (Privilege obj : privilegeService.findAll()) {
            PrivilegeJson json = new PrivilegeJson();
            json.setPrivilegeCode(obj.getPrivilegeCode());
            json.setPrivilegeName(obj.getPrivilegeName());
            json.setChecked(false);
            list.add(json);
        }

        return list;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn update(@RequestParam(value = "roleCode", required = true) String roleCode,
            @RequestParam(value = "roleName", required = true) String roleName,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "status", required = true) String status) {

        Role role = null;
        JsonReturn jsonReturn = new JsonReturn();
        try {
            role = roleService.findByRoleID(roleCode);
            if (role == null) {
                throw new BussinessException("not existing user role");
            }

            role.setDescription(description);
            role.setModifiedBy(userName);
            role.setModifiedDate(new Date());

            role.setStatus(GeneralStatus.find(status));

            roleService.update(role);

            jsonReturn.setSuccess("true");
            jsonReturn.setResult(role.getRoleName());

        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> obj2 : e.getConstraintViolations()) {
                System.out.println(obj2.getRootBeanClass().getName());
                System.out.println(obj2.getPropertyPath());
                System.out.println(obj2.getInvalidValue());
                System.out.println(obj2.getConstraintDescriptor());
                System.out.println(obj2.getMessage());
            }
            LOGGER.warn("institueConstraintViolation()", e);
            e.printStackTrace();
        } catch (BussinessException e) {

            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMsg());
            jsonReturn.setErrorCode("123");
            LOGGER.error("saveRole(name)", e);
            e.printStackTrace();

        } catch (Exception e) {
            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMessage());
            jsonReturn.setErrorCode("123");
            LOGGER.error("saveRole()", e);
            e.printStackTrace();
        }
        return jsonReturn;
    }

    @RequestMapping(value = "/find/json", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<RoleJson> findBySearch(@RequestParam(value = "roleName", required = false) String roleName,
            @RequestParam(value = "userType", required = false) String userType,
            @RequestParam(value = "userCategory", required = false) String userCategory) {
        return this.toJson(roleService.findByRoleNameUserTypeANDUserCate(roleName, userType, userCategory));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<RoleJson> findAll() {
        return this.toJson(roleService.findAll());
    }

    @RequestMapping(value = "/findAllRoles", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<RoleJson> findAllRoles(@RequestParam(value = "userType", required = false) String userType) {

        List<Role> roles = new ArrayList<>();

        if (UserTypes.find(userType).equalsIgnoreCase(UserTypes.STUDENT)) {
            userType = UserTypes.STUDENT;
            roles = roleService.findByUserType(userType);
        } else if (UserTypes.find(userType).equalsIgnoreCase(UserTypes.PARENT)) {
            userType = UserTypes.PARENT;
            roles = roleService.findByUserType(userType);
        } else {
            roles = roleService.findByStatus(GeneralStatus.ACTIVE);
        }

        return this.toJson(roles);
    }

    @RequestMapping(value = "/findAllocated", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<RoleJson> findAllocated(@RequestParam(value = "userName", required = false) String userName) {

        List<UserRoleLink> userRoleLinkList = userRoleLinkService.findByUserName(userName);
        List<Role> roleList = new ArrayList<>();

        for (UserRoleLink userRoleLink : userRoleLinkList) {

            Role roleObj = roleService.findByRoleID(userRoleLink.getUserRoleLinkPK().getRoleCode());
            roleList.add(roleObj);

        }

        return this.toJson(roleList);

    }

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
