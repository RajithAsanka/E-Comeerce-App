/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.controller;

import com.imperia.core.ResourceClientProxyPool;
import com.imperia.requests.CategoryRequest;
import com.nr.fc.controller.util.GroupJsonUtil;
import com.nr.fc.exception.BussinessException;
import com.nr.fc.json.model.JsonReturn;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Rajith
 */
@Controller
@RequestMapping(value = ServicePath.ADMIN_PREFIX + ServicePath.CREATE_CATEGORY)
public class CategoryController {

    @Autowired
    private GroupJsonUtil groupJsonUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn save(@RequestParam(value = "categoryName", required = false) String categoryName,
            @RequestParam(value = "maincategory", required = false) String maincategory,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "username", required = true) String username) {

        JsonReturn jsonReturn = new JsonReturn();

        try {

            //  ResourceClientProxyPool.getInstance().getUserResourceClient().getUser();
            CategoryRequest categoryRequest = new CategoryRequest();
            categoryRequest.setMainCategory(maincategory);
            categoryRequest.setCategoryName(categoryName);
            categoryRequest.setDescription(description);
            categoryRequest.setStatus(status);
            categoryRequest.setUserName(username);

            CategoryRequest res = ResourceClientProxyPool.getInstance().getCategoryResourceClient().saveCateogry(categoryRequest);

            jsonReturn.setSuccess("true");
            jsonReturn.setResult(res.getCategoryName());

        } catch (BussinessException e) {
            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMsg());
            jsonReturn.setErrorCode("123");
            e.printStackTrace();
        } catch (Exception e) {
            jsonReturn.setSuccess("false");
            jsonReturn.setErrorMessage(e.getMessage());
            jsonReturn.setErrorCode("123");
            LOGGER.error("Exception Occured", e);
            e.printStackTrace();
        }
        return jsonReturn;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn update(
            @RequestParam(value = "groupId", required = true) String groupId,
            @RequestParam(value = "groupName", required = true) String groupName,
            @RequestParam(value = "establishment", required = true) String establishment,
            @RequestParam(value = "groupOfficer", required = true) String groupOfficerId,
            @RequestParam(value = "meetingDay", required = true) String meetingDay,
            @RequestParam(value = "groupBranch", required = true) String groupBranch,
            @RequestParam(value = "groupAddress", required = true) String groupAddress,
            @RequestParam(value = "contactNumber", required = true) String contactNumber,
            @RequestParam(value = "details", required = true) String details,
            @RequestParam(value = "status", required = true) String status,
            @RequestParam(value = "username", required = true) String username) {

        JsonReturn jsonReturn = new JsonReturn();

        jsonReturn.setSuccess("true");
        jsonReturn.setResult("");

        return jsonReturn;
    }

    @RequestMapping(value = "/find/all", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public void findAll() {

        List<CategoryRequest> list = new ArrayList<CategoryRequest>();
        list = ResourceClientProxyPool.getInstance().getCategoryResourceClient().findAll();
        
        
    }
}
