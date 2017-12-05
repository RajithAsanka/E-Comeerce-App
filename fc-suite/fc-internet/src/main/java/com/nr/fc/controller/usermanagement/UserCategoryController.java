/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.controller.usermanagement;

import com.nr.fc.controller.ServicePath;
import com.nr.fc.enums.GeneralStatus;
import com.nr.fc.exception.BussinessException;
import com.nr.fc.json.model.JsonReturn;
import com.nr.fc.json.model.UserCategoryJson;
import com.nr.fc.model.UserCategory;
import com.nr.fc.model.UserCategoryPK;
import com.nr.fc.model.UserType;
import com.nr.fc.service.user.UserCategoryService;
import com.nr.fc.service.user.UserTypeService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Madhuranga Samarasinghe
 */
@Controller
@RequestMapping(value = ServicePath.ADMIN_PREFIX + ServicePath.USER_CATEGORY, method = RequestMethod.POST, headers = "Accept=application/json")
public class UserCategoryController {

    @Autowired
    private UserTypeService userTypeService;

    @Autowired
    private UserCategoryService userCategoryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCategoryController.class);

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<UserCategoryJson> findAll() {

        return this.toJson(userCategoryService.findAll());

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    @ExceptionHandler({BussinessException.class})
    public JsonReturn save(
            @RequestParam(value = "userCategory", required = true) String userCategory,
            @RequestParam(value = "userType", required = true) String userType,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "status", required = true) String status,
            @RequestParam(value = "username", required = true) String username
    ) {

        JsonReturn jsonReturn = new JsonReturn();
        try {

            UserCategory userCategory1 = null;

            userCategory1 = userCategoryService.findById(new UserCategoryPK(userCategory, userType));

            if (userCategory1 != null) {
                throw new BussinessException("existing user Category");
            }

            UserType userType1 = userTypeService.findById(userType);
            if (userType1 == null) {
                throw new BussinessException("user type not existing");
            }

            userCategory1 = new UserCategory();
            userCategory1.setAddedBy(username);
            userCategory1.setAddedDate(new Date());
            userCategory1.setDescription(description);
            userCategory1.setModifiedBy(username);
            userCategory1.setModifiedDate(new Date());
            userCategory1.setStatus(GeneralStatus.find(status));
            userCategory1.setUserCategoryPK(new UserCategoryPK(userCategory, userType));
            userCategory1.setUserType(userType1);

            userCategoryService.save(userCategory1);

            jsonReturn.setSuccess("true");
            jsonReturn.setResult(userCategory1.getUserCategoryPK().getUserCategory());
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> obj2 : e.getConstraintViolations()) {
                System.out.println(obj2.getRootBeanClass().getName());
                System.out.println(obj2.getPropertyPath());
                System.out.println(obj2.getInvalidValue());
                System.out.println(obj2.getConstraintDescriptor());
                System.out.println(obj2.getMessage());
            }
            LOGGER.warn("userCategoryConstraintViolation()", e);
            e.printStackTrace();
        } catch (BussinessException e) {

            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMsg());
            jsonReturn.setErrorCode("123");
            LOGGER.error("saveClub(name)", e);
            e.printStackTrace();

        } catch (Exception e) {
            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMessage());
            jsonReturn.setErrorCode("123");
            LOGGER.error("saveClub()", e);
            e.printStackTrace();
        }
        return jsonReturn;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    @ExceptionHandler({BussinessException.class})
    public JsonReturn update(
            @RequestParam(value = "userCategory") String userCategory,
            @RequestParam(value = "userType") String userType,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "status") String status,
            @RequestParam(value = "username") String username
    ) {

        JsonReturn jsonReturn = new JsonReturn();
        try {

            UserCategory userCategory1 = null;

            userCategory1 = userCategoryService.findById(new UserCategoryPK(userCategory, userType));

            if (userCategory1 == null) {
                new BussinessException("not existing user Category");
            }

            UserType userType1 = userTypeService.findById(userType);
            if (userType1 == null) {
                new BussinessException("user type not existing");
            }

            userCategory1.setDescription(description);
            userCategory1.setModifiedBy(username);
            userCategory1.setModifiedDate(new Date());
            userCategory1.setStatus(GeneralStatus.find(status));

            userCategoryService.update(userCategory1);

            jsonReturn.setSuccess("true");
            jsonReturn.setResult(userCategory1.getUserCategoryPK().getUserCategory());
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
            LOGGER.error("saveClub(name)", e);
            e.printStackTrace();

        } catch (Exception e) {
            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMessage());
            jsonReturn.setErrorCode("123");
            LOGGER.error("saveClub()", e);
            e.printStackTrace();
        }
        return jsonReturn;
    }

    public List<UserCategoryJson> toJson(List<UserCategory> list) {

        List<UserCategoryJson> listReturn = new ArrayList<>();
        for (UserCategory userCategory : list) {
            listReturn.add(toJson(userCategory));
        }
        return listReturn;
    }

    private UserCategoryJson toJson(UserCategory userCategory) {
        UserCategoryJson userCategoryJson = new UserCategoryJson();
        userCategoryJson.setUserCategory(userCategory.getUserCategoryPK().getUserCategory());
        userCategoryJson.setDecription(userCategory.getDescription());
        userCategoryJson.setStatus(userCategory.getStatus());
        userCategoryJson.setUserType(userCategory.getUserType().getUserType());
        return userCategoryJson;
    }

}
