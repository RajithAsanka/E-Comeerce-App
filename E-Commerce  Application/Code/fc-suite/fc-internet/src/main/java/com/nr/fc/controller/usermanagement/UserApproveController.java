package com.nr.fc.controller.usermanagement;

import com.nr.fc.common.JsonConverter;
import com.nr.fc.controller.ServicePath;
import com.nr.fc.criteria.EmployeeCriteria;
import com.nr.fc.email.UserApproveEmail;
import com.nr.fc.enums.EmailEnum;
import com.nr.fc.enums.GeneralStatus;
import com.nr.fc.enums.UserStatus;
import com.nr.fc.enums.UserTypes;
import com.nr.fc.exception.BussinessException;
import com.nr.fc.json.model.EmployeeJson;
import com.nr.fc.json.model.JsonReturn;

import com.nr.fc.json.model.UserJson;

import com.nr.fc.model.Employee;

import com.nr.fc.model.Role;

import com.nr.fc.model.User;
import com.nr.fc.service.employee.EmployeeService;

import com.nr.fc.service.user.UserService;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = ServicePath.ADMIN_PREFIX + ServicePath.USER_APPROVAL)
public class UserApproveController {

    private SecureRandom random = new SecureRandom();

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @Autowired
    private JsonConverter jsonConverter;

    @Autowired
    private UserApproveEmail userApproveEmail;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApproveController.class);

    @RequestMapping(value = "/find/employee/search", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<EmployeeJson> findEmployees(@RequestParam(value = "departmentId", required = false) String departmentId,
            @RequestParam(value = "employeeRef", required = false) String employeeRef,
            @RequestParam(value = "employeeNIC", required = false) String employeeNIC,
            @RequestParam(value = "approveMode", required = false) String approveMode,
            @RequestParam(value = "userStatus", required = false) String userStatus
    ) {
        EmployeeCriteria employeeCriteria = new EmployeeCriteria();
        employeeCriteria.setDepartmentId(departmentId);
        employeeCriteria.setRegNo(employeeRef);
        employeeCriteria.setNicNo(employeeNIC);
        employeeCriteria.setApproveMode(approveMode);
        employeeCriteria.setUserStatus(userStatus);

        return this.toEmployeeJson(employeeService.findByCriteria(employeeCriteria));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn save(@RequestParam(value = "userType", required = true) String userType,
            @RequestParam(value = "userRef", required = true) String userRef,
            @RequestParam(value = "description", required = false) String comment,
            @RequestParam(value = "status", required = true) String status,
            @RequestParam(value = "roles", required = false) String roles,
            @RequestParam(value = "username", required = true) String username) {

        User user = null;
        JsonReturn jsonReturn = new JsonReturn();
        try {

            if (userType == null || userType.equals("")) {
                throw new BussinessException("not existing user types");
            }

            if (userRef == null || userRef.equals("")) {
                throw new BussinessException("not existing selected user");
            }

            user = userService.findByUserName(userRef);
            if (user != null) {
                throw new BussinessException("existing username");
            }

            user = new User();
            user.setAddedBy(username);
            user.setAddedDate(new Date());
            user.setDescription(comment);
            user.setModifiedBy(username);
            user.setModifiedDate(new Date());
            user.setStatus(GeneralStatus.ACTIVE);
            user.setApproveMode(UserStatus.find(status));
            user.setFirstTimeLogin(Boolean.TRUE);

            List<Role> list = new ArrayList<>();

            list = jsonConverter.convertRole(roles);

            String pass = this.nextSessionId();

            System.out.println("password : " + pass);

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(pass);
            user.setPassword(hashedPassword);

            if (UserTypes.find(userType).equals(UserTypes.EMPLOYEE)) {
                Employee employee = employeeService.findByEmployeeId(userRef);
                if (employee == null) {
                    throw new BussinessException("wrong employee ref");
                }

                user.setEmployeeId(employee);
                user.setUserType(UserTypes.EMPLOYEE);
                user.setUserName(employee.getEmployeeId());

            }

            if (UserStatus.find(status).equals(UserStatus.APPROVED)) {
                //need to forword email

                String result = userApproveEmail.sendApproveEmail(user, pass, "firsttimelogin");
                if (EmailEnum.find(result).equals(EmailEnum.SENT)) {
                    userService.save(user, list, username);
                } else {
                    throw new BussinessException("Failed to send the email. Please check your network connection and try again");
                }

            }
            if (UserStatus.find(status).equals(UserStatus.REJECTED)) {
                userService.save(user, list, username);
            }
            if (UserStatus.find(status).equals(UserStatus.SUSPENDED)) {
                userService.save(user, list, username);
            }

            jsonReturn.setSuccess("true");
            jsonReturn.setResult(user.getUserName());

        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> obj2 : e.getConstraintViolations()) {
                System.out.println(obj2.getRootBeanClass().getName());
                System.out.println(obj2.getPropertyPath());
                System.out.println(obj2.getInvalidValue());
                System.out.println(obj2.getConstraintDescriptor());
                System.out.println(obj2.getMessage());
            }
            LOGGER.warn("userApproveConstraintViolation()", e);
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

    @RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn update(
            @RequestParam(value = "userType", required = false) String userType,
            @RequestParam(value = "description", required = false) String comment,
            @RequestParam(value = "allocatedRoles", required = true) String allocatedRoles,
            @RequestParam(value = "roles", required = false) String roles,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "userTypeId", required = true) String userTypeId
    ) {

        User user = null;
        JsonReturn jsonReturn = new JsonReturn();
        try {

            user = userService.findByUserName(userTypeId);
            if (user != null) {
                user.setDescription(comment);
                user.setModifiedBy(username);
                user.setModifiedDate(new Date());
                user.setStatus(GeneralStatus.ACTIVE);
            }

            List<Role> allocatedRoleslist = jsonConverter.convertRole(allocatedRoles);
            List<Role> roleslist = jsonConverter.convertRole(roles);

            userService.update(user, allocatedRoleslist, roleslist, username);

            jsonReturn.setSuccess("true");
            jsonReturn.setResult(user.getUserName());

        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> obj2 : e.getConstraintViolations()) {
                System.out.println(obj2.getRootBeanClass().getName());
                System.out.println(obj2.getPropertyPath());
                System.out.println(obj2.getInvalidValue());
                System.out.println(obj2.getConstraintDescriptor());
                System.out.println(obj2.getMessage());
            }
            LOGGER.warn("userApproveConstraintViolation()", e);
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

    @RequestMapping(value = "/approveRejected", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn approveRejected(
            @RequestParam(value = "userType", required = false) String userType,
            @RequestParam(value = "description", required = false) String comment,
            @RequestParam(value = "allocatedRoles", required = true) String allocatedRoles,
            @RequestParam(value = "roles", required = false) String roles,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "userTypeId", required = true) String userTypeId
    ) {

        User user = null;
        JsonReturn jsonReturn = new JsonReturn();
        try {

            String pass = this.nextSessionId();

            System.out.println("password : " + pass);

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(pass);

            user = userService.findByUserName(userTypeId);
            if (user != null) {
                user.setDescription(comment);
                user.setApproveMode(UserStatus.APPROVED);
                user.setModifiedBy(username);
                user.setModifiedDate(new Date());
                user.setFirstTimeLogin(Boolean.TRUE);
                user.setPassword(hashedPassword);

            }

            List<Role> allocatedRoleslist = jsonConverter.convertRole(allocatedRoles);
            List<Role> roleslist = jsonConverter.convertRole(roles);

            userService.update(user, allocatedRoleslist, roleslist, username);

            if (UserStatus.find(user.getApproveMode()).equals(UserStatus.APPROVED)) {
                //need to forword email
                userApproveEmail.sendApproveEmail(user, pass, "firsttimelogin");

            }

            jsonReturn.setSuccess("true");
            jsonReturn.setResult(user.getUserName());

        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> obj2 : e.getConstraintViolations()) {
                System.out.println(obj2.getRootBeanClass().getName());
                System.out.println(obj2.getPropertyPath());
                System.out.println(obj2.getInvalidValue());
                System.out.println(obj2.getConstraintDescriptor());
                System.out.println(obj2.getMessage());
            }
            LOGGER.warn("userReApproveConstraintViolation()", e);
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

    @RequestMapping(value = "/userUnlock", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn userUnlock(
            @RequestParam(value = "userType", required = false) String userType,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "userTypeId", required = true) String userTypeId,
            @RequestParam(value = "status", required = true) String status,
            @RequestParam(value = "resetpassword", required = true) boolean resetpassword
    ) {

        User user = null;
        JsonReturn jsonReturn = new JsonReturn();
        try {

            String sendingResult = "";

            user = userService.findByUserName(userTypeId);
            if (user != null) {

                user.setModifiedBy(username);
                user.setModifiedDate(new Date());

                if (status.equalsIgnoreCase(UserStatus.SUSPENDED)) {
                    user.setStatus(UserStatus.SUSPENDED);
                } else {

                    if (resetpassword) {

                        user = userService.findByUserNameANDActiveApproveExpertAdmin(userTypeId);

                        if (user == null) {
                            throw new BussinessException("Invalid username");
                        }

                        String pass = this.nextSessionId();

                        System.out.println("password : " + pass);

                        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                        String hashedPassword = passwordEncoder.encode(pass);

                        user.setFirstTimeLogin(Boolean.TRUE);
                        user.setPassword(hashedPassword);
                        user.setModifiedBy(username);
                        user.setModifiedDate(new Date());

                        userService.updatePassword(user);

                        //need to forword email
                        sendingResult = userApproveEmail.sendApproveEmail(user, pass, "passwordreset");

                        if (sendingResult.equalsIgnoreCase("Sent")) {
                            sendingResult = "Email Sent to your email";
                        } else {
                            sendingResult = " failed , Invalid email address. email not sent";
                        }
                    }
                    user.setStatus(GeneralStatus.ACTIVE);
                }

            }

            userService.update(user);
            jsonReturn.setSuccess("true");

            if (resetpassword) {
                jsonReturn.setResult(user.getUserName() + "  Password reset , " + sendingResult);
            } else {
                jsonReturn.setResult(user.getUserName());

            }

        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> obj2 : e.getConstraintViolations()) {
                System.out.println(obj2.getRootBeanClass().getName());
                System.out.println(obj2.getPropertyPath());
                System.out.println(obj2.getInvalidValue());
                System.out.println(obj2.getConstraintDescriptor());
                System.out.println(obj2.getMessage());
            }
            LOGGER.warn("userUnlockConstraintViolation()", e);
            e.printStackTrace();
        } catch (BussinessException e) {

            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMsg());
            jsonReturn.setErrorCode("123");
            LOGGER.error("userUnlock(name)", e);
            e.printStackTrace();

        } catch (Exception e) {
            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMessage());
            jsonReturn.setErrorCode("123");
            LOGGER.error("userUnlock()", e);
            e.printStackTrace();
        }
        return jsonReturn;
    }

    @RequestMapping(value = "/findByUsername", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public UserJson findLikeUser(@RequestParam(value = "username", required = false) String username) throws Exception {

        return toJson(userService.findByUserNameAndStatus(username));
    }

    public UserJson toJson(User user) {

        UserJson userJson = new UserJson();
        userJson.setUserName(user.getUserName());
        userJson.setUserType(user.getUserName());
        userJson.setDescription(user.getDescription());
        userJson.setStatus(user.getStatus());

        return userJson;

    }

    public List<EmployeeJson> toEmployeeJson(List<Employee> list) {

        List<EmployeeJson> listReturn = new ArrayList<>();
        for (Employee employee : list) {
            listReturn.add(toEmployeeJson(employee));
        }
        return listReturn;
    }

    public EmployeeJson toEmployeeJson(Employee employee) {
        EmployeeJson json = new EmployeeJson();
        try {
            json.setEmployeeId(employee.getEmployeeId());
            StringBuilder name = new StringBuilder();
            name.append(employee.getSalutaionId());
            name.append(" ");
            name.append(employee.getFirstName());
            name.append(" ");
            name.append(employee.getLastName());
            json.setFirstName(name.toString());
            User user = userService.findByEmployeeId(employee.getEmployeeId());
            if (user != null && user.getApproveMode().equalsIgnoreCase(UserStatus.APPROVED)) {
                json.setApproved("YES");
            } else if (user != null && user.getApproveMode().equalsIgnoreCase(UserStatus.REJECTED)) {
                json.setApproved("Rejected");
            } else {
                json.setApproved("NO");
            }
            //set user status
            if (user != null) {
                json.setStatus(user.getStatus());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    public String nextSessionId() {
        return new BigInteger(32, random).toString(32);
    }

}
