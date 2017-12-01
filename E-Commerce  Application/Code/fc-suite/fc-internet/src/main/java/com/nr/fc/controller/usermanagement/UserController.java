
package com.nr.fc.controller.usermanagement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nr.fc.controller.ServicePath;
import com.nr.fc.email.UserApproveEmail;
import com.nr.fc.exception.BussinessException;
import com.nr.fc.json.model.JsonReturn;
import com.nr.fc.model.User;
import com.nr.fc.model.UserPasswordAudit;
import com.nr.fc.service.user.UserPasswordAuditService;
import com.nr.fc.service.user.UserService;
import com.nr.fc.util.PasswordValidator;
import java.math.BigInteger;
import java.security.SecureRandom;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Mohamed Sayyaff
 *
 */
@Controller
@RequestMapping(value = ServicePath.ADMIN_PREFIX + ServicePath.USER)
public class UserController {

    private SecureRandom random = new SecureRandom();

    @Autowired
    private UserService userService;

    @Autowired
    private UserPasswordAuditService userPasswordAuditService;
    
    @Autowired
    private UserApproveEmail userApproveEmail;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<User> findAllUser() throws Exception {
        return userService.findAll();
    }

    @RequestMapping(value = "/passwordChange", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn passwordChange(@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "currentPass", required = true) String currentPass,
            @RequestParam(value = "newPass", required = true) String newPass) {

        User user = null;
        JsonReturn jsonReturn = new JsonReturn();
        try {

            user = userService.findByUserName(username);
            if (user == null) {
                throw new BussinessException("not existing user");
            }

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            String currentPasswor = passwordEncoder.encode(currentPass);
            System.out.println("current pass : " + currentPasswor);
            if (!passwordEncoder.matches(currentPass, user.getPassword())) {
                throw new BussinessException("current password is incorrect.");
            }

            if (currentPass == null || newPass == null || currentPass.isEmpty() || newPass.isEmpty()) {
                throw new BussinessException("please set current password or new password");
            }

            if (currentPass.equals(newPass)) {
                throw new BussinessException("currect Password & new password are same,please try another password.");
            }

            String hashedPassword = passwordEncoder.encode(newPass);

            List<UserPasswordAudit> userPasswordAudit = userPasswordAuditService.findByPassword(hashedPassword);
            if (userPasswordAudit != null && !userPasswordAudit.isEmpty()) {
                throw new BussinessException("3 last history passwords have dittected,please try another password.");
            }

            if (!new PasswordValidator().validate(newPass)) {
                throw new BussinessException("Please enter a password with more than 6 characters and minimum 20. Your password has to be a combination of lower & upper case letters, special characters and numbers.");
            }

            user.setPassword(hashedPassword);
            user.setModifiedBy(username);
            user.setModifiedDate(new Date());

            userService.updatePassword(user);

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
            LOGGER.warn("institueConstraintViolation()", e);
            e.printStackTrace();
        } catch (BussinessException e) {

            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMsg());
            jsonReturn.setErrorCode("123");
            LOGGER.error("saveRole(name)", e);
            //e.printStackTrace();

        } catch (Exception e) {
            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMessage());
            jsonReturn.setErrorCode("123");
            LOGGER.error("saveRole()", e);
            e.printStackTrace();
        }
        return jsonReturn;
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn forgotPassword(@RequestParam(value = "username", required = true) String username) {

        User user = null;
        JsonReturn jsonReturn = new JsonReturn();
        try {

            user = userService.findByUserNameANDActiveApproveExpertAdmin(username);
            if (user == null) {
                throw new BussinessException("please enter valid username");
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
            String sendingResult = userApproveEmail.sendApproveEmail(user, pass,"forgetpassword");
                
            if(sendingResult.equalsIgnoreCase("Sent")){
                sendingResult = "Email Sent to your email";
            }else{
                sendingResult = "Invalid email address. email not sent";
            }

            jsonReturn.setSuccess("true");
            jsonReturn.setResult(user.getUserName()+"Password reset. "+sendingResult);

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
            //e.printStackTrace();

        } catch (Exception e) {
            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMessage());
            jsonReturn.setErrorCode("123");
            LOGGER.error("saveRole()", e);
            e.printStackTrace();
        }
        return jsonReturn;
    }

    
    @RequestMapping(value = "/firstTimelogin", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn firstTimelogin(@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password) {

        User user = null;
        JsonReturn jsonReturn = new JsonReturn();
        try {

            user = userService.findByUserNameANDActiveApproveExpertAdmin(username);
            if (user == null) {
                throw new BussinessException("not existing user");
            }

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            

            if (password == null || password.isEmpty()) {
                throw new BussinessException("please set password");
            }

            

            String hashedPassword = passwordEncoder.encode(password);

            List<UserPasswordAudit> userPasswordAudit = userPasswordAuditService.findByPassword(hashedPassword);
            if (userPasswordAudit != null && !userPasswordAudit.isEmpty()) {
                throw new BussinessException("3 last history passwords have dittected,please try another password.");
            }

            if (!new PasswordValidator().validate(password)) {
                throw new BussinessException("Please enter a password with more than 6 characters and minimum 20. Your password has to be a combination of lower & upper case letters, special characters and numbers.");
            }

            user.setPassword(hashedPassword);
            user.setModifiedBy(username);
            user.setModifiedDate(new Date());
            user.setFirstTimeLogin(Boolean.FALSE);

            userService.updatePassword(user);

            jsonReturn.setSuccess("true");
            jsonReturn.setResult("Password updated in "+user.getUserName());

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
            //e.printStackTrace();

        } catch (Exception e) {
            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMessage());
            jsonReturn.setErrorCode("123");
            LOGGER.error("saveRole()", e);
            e.printStackTrace();
        }
        return jsonReturn;
    }
    
    public String nextSessionId() {
        return new BigInteger(32, random).toString(32);
    }

}
