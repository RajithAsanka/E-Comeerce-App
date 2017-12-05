
package com.nr.fc.service.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nr.fc.dao.UserDao;
import com.nr.fc.dao.UserRoleLinkDao;
import com.nr.fc.enums.GeneralStatus;
import com.nr.fc.enums.UserStatus;
import com.nr.fc.model.Role;
import com.nr.fc.model.User;
import com.nr.fc.model.UserPasswordAudit;
import com.nr.fc.model.UserRoleLink;
import com.nr.fc.model.UserRoleLinkPK;
import com.nr.fc.service.user.PrivilegeService;
import com.nr.fc.service.user.RoleService;
import com.nr.fc.service.user.UserPasswordAuditService;
import com.nr.fc.service.user.UserRoleLinkService;
import com.nr.fc.service.user.UserService;
import java.util.Date;

/**
 *
 * @author Amith
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private UserRoleLinkDao userRoleLinkDao;

    @Autowired
    private UserRoleLinkService roleLinkService;
    
    @Autowired
    private UserPasswordAuditService userPasswordAuditService;
    
    @Transactional
    @Override
    public void save(User user) throws Exception {
        userDao.create(user);
    }

    @Transactional
    @Override
    public void update(User user) throws Exception {
        userDao.update(user);
    }

    @Transactional
    @Override
    public void delete(User user) throws Exception {
        userDao.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findByStatus(String status) {
        String sql = "SELECT a FROm User a WHERE a.status=:status";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", status);
        return userDao.findbyQuery(sql, params);
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.read(userName);
    }

    @Override
    public User findByUserNameAndStatus(String userName) {

        String sql = "SELECT a FROM User a WHERE  a.userName = :userName ";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        return userDao.findbyQuerySingle(sql, params);

    }

    @Override
    public User initUserPrivilages(String userName) {
        User user = userDao.read(userName);
    //    user.setPrivileges(roleService.findPrivilegesByRoleName(user.getUserName()));
        return user;
    }

    @Override
    public User initSystemUser(String username) {
        User user = userDao.read(username);
//        if(user!=null && user.getUserType().equalsIgnoreCase(UserTypes.PARENT) && user.getParentGuardianId()!=null){
//            List<StudentParentGuardian> studentParentGuardians = studentParentGuardianService.findByParentId(user.getParentGuardianId().getParentGuardianId());
//            List<Student> students = new ArrayList<Student>();
//            for (StudentParentGuardian studentParentGuardian : studentParentGuardians) {
//                students.add(studentParentGuardian.getStudent());
//            }
//            user.getParentGuardianId().setStudentList(students);
//        }
//        user.setPrivileges(roleService.findPrivilegesByRoleName(user.getUserName()));
        return user;
    }

    @Override
    public User findByStudentId(String studentId) {
        String sql = "SELECT a FROM User a WHERE a.studentId.studentId =:studentId";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("studentId", studentId);
        return userDao.findbyQuerySingle(sql, params);
    }

    @Override
    public User findByParentGuardianId(String parentGuardianId) {
        String sql = "SELECT a FROM User a WHERE a.parentGuardianId.parentGuardianId =:parentGuardianId";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parentGuardianId", parentGuardianId);
        return userDao.findbyQuerySingle(sql, params);
    }

    @Override
    public User findByEmployeeId(String employeeId) {
        String sql = "SELECT a FROM User a WHERE a.employeeId.employeeId =:employeeId";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("employeeId", employeeId);
        return userDao.findbyQuerySingle(sql, params);
    }

    @Override
    @Transactional
    public void save(User user, List<Role> list, String username) {

        userDao.create(user);

        for (Role role : list) {
            UserRoleLink userRoleLink = new UserRoleLink();
            userRoleLink.setAddedBy(username);
            userRoleLink.setAddedDate(new Date());
            userRoleLink.setModifiedBy(username);
            userRoleLink.setModifiedDate(new Date());
            userRoleLink.setRole(role);
            userRoleLink.setStatus(GeneralStatus.ACTIVE);
            userRoleLink.setUser(user);
            userRoleLink.setUserRoleLinkPK(new UserRoleLinkPK(user.getUserName(), role.getRoleCode()));
            userRoleLinkDao.create(userRoleLink);
        }
    }

    @Override
    public User findByUserNameANDActiveApprove(String username) {
        String sql = "SELECT a FROM User a WHERE a.userName =:userName AND a.status =:status AND a.approveMode =:approveMode";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", username);
        params.put("status", GeneralStatus.ACTIVE);
        params.put("approveMode", UserStatus.APPROVED);
        return userDao.findbyQuerySingle(sql, params);
    }

    @Transactional
    @Override
    public void update(User user, List<Role> allocatedrolesList, List<Role> rolesList, String username) {

        userDao.update(user);

        for (Role role : allocatedrolesList) {

            UserRoleLinkPK userRoleLinkPK = new UserRoleLinkPK();
            userRoleLinkPK.setUserName(user.getUserName());
            userRoleLinkPK.setRoleCode(role.getRoleCode());

            UserRoleLink userRoleLink = roleLinkService.findByPK(userRoleLinkPK);

            if (userRoleLink == null) {

                userRoleLink = new UserRoleLink();
                userRoleLink.setUserRoleLinkPK(userRoleLinkPK);
                userRoleLink.setStatus(GeneralStatus.ACTIVE);
                userRoleLink.setAddedBy(username);
                userRoleLink.setAddedDate(new Date());
                userRoleLink.setModifiedBy(username);
                userRoleLink.setModifiedDate(new Date());
                userRoleLink.setUser(user);
                userRoleLink.setRole(role);
                userRoleLinkDao.create(userRoleLink);

            } else {
                userRoleLink.setUserRoleLinkPK(userRoleLinkPK);
                userRoleLink.setStatus(GeneralStatus.ACTIVE);
                userRoleLink.setModifiedBy(username);
                userRoleLink.setModifiedDate(new Date());
                userRoleLinkDao.update(userRoleLink);

            }

        }

        for (Role rolesList1 : rolesList) {

            UserRoleLinkPK userRoleLinkPK = new UserRoleLinkPK();
            userRoleLinkPK.setUserName(user.getUserName());
            userRoleLinkPK.setRoleCode(rolesList1.getRoleCode());

            UserRoleLink userRoleLink = roleLinkService.findByPK(userRoleLinkPK);

            if (userRoleLink != null) {

                userRoleLink.setStatus(GeneralStatus.DEACTIVE);
                userRoleLink.setModifiedBy(username);
                userRoleLink.setModifiedDate(new Date());
                userRoleLinkDao.update(userRoleLink);

            }

        }
    }

    @Override
    @Transactional
    public void updatePassword(User user) {
        User user1 = this.findByUserName(user.getUserName());
        
        userDao.update(user);
        
        UserPasswordAudit userPasswordAudit = new UserPasswordAudit();
        userPasswordAudit.setAddedBy(user.getUserName());
        userPasswordAudit.setAddedDate(new Date());
        userPasswordAudit.setModifiedBy(user.getUserName());
        userPasswordAudit.setModifiedDate(new Date());
        userPasswordAudit.setPassword(user1.getPassword());
        userPasswordAudit.setStatus(GeneralStatus.ACTIVE);
        userPasswordAudit.setUserName(user1);
        userPasswordAuditService.save(userPasswordAudit);
        
        
    }

    @Override
    public User findByUserNameANDActiveApproveExpertAdmin(String username) {
        String sql = "SELECT a FROM User a WHERE a.userName =:userName AND a.status =:status AND a.approveMode =:approveMode AND a.userName != 'admin'";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", username);
        params.put("status", GeneralStatus.ACTIVE);
        params.put("approveMode", UserStatus.APPROVED);
        return userDao.findbyQuerySingle(sql, params);
    }

}
