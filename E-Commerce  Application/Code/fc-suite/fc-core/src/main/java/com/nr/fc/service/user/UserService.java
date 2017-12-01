package com.nr.fc.service.user;

import com.nr.fc.model.Role;
import java.util.List;

import com.nr.fc.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 *
 * @author Amith
 */
public interface UserService {

    /**
     * Save.
     *
     * @param user the user
     * @throws Exception the exception
     */
    public void save(User user) throws Exception;

    /**
     * Update.
     *
     * @param user the user
     * @throws Exception the exception
     */
    public void update(User user) throws Exception;

    /**
     * Delete.
     *
     * @param user the user
     * @throws Exception the exception
     */
    public void delete(User user) throws Exception;

    /**
     * Find all.
     *
     * @return the list
     */
    public List<User> findAll();

    /**
     * Find by status.
     *
     * @param status the status
     * @return the list
     */
    public List<User> findByStatus(String status);

    /**
     * Find by user name.
     *
     * @param userName the user name
     * @return the user
     */
    public User findByUserName(String userName);

    /**
     *
     * @param userName
     * @return
     */
    public User findByUserNameAndStatus(String userName);

    /**
     * Inits the user privilages.
     *
     * @param userName the user name
     * @return the user
     */
    public User initUserPrivilages(String userName);

    /**
     * Inits the system user.
     *
     * @param username the username
     * @return the user
     */
    public User initSystemUser(String username);

    /**
     *
     * @param studentId
     * @return
     */
    public User findByStudentId(String studentId);

    /**
     *
     * @param parentGuardianId
     * @return
     */
    public User findByParentGuardianId(String parentGuardianId);

    /**
     * *
     *
     * @param employeeId
     * @return
     */
    public User findByEmployeeId(String employeeId);

    /**
     *
     * @param user
     * @param list
     * @param username
     */
    public void save(User user, List<Role> list, String username);

    /**
     *
     * @param user
     * @param allocatedrolesList
     * @param rolesList
     * @param username
     */
    public void update(User user, List<Role> allocatedrolesList, List<Role> rolesList, String username);

    /**
     *
     * @param username
     * @return
     */
    public User findByUserNameANDActiveApprove(String username);

    /**
     *
     * @param user
     */
    public void updatePassword(User user);

    /**
     *
     * @param username
     * @return
     */
    public User findByUserNameANDActiveApproveExpertAdmin(String username);

}
