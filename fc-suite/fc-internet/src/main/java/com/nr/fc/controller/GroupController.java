/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.controller;

import com.nr.fc.controller.util.GroupJsonUtil;
import com.nr.fc.exception.BussinessException;
import com.nr.fc.json.model.GroupJson;
import com.nr.fc.json.model.JsonReturn;
import com.nr.fc.model.CustomerGroup;
import com.nr.fc.model.Employee;
import com.nr.fc.service.customergroup.CustomerGroupService;
import com.nr.fc.service.employee.EmployeeService;
import com.nr.fc.util.DateUtil;
import com.nr.fc.util.DateUtil.Formats;
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
 * @author Naveen
 */
@Controller
@RequestMapping(value = ServicePath.ADMIN_PREFIX + ServicePath.CREATE_GROUP)
public class GroupController {

    @Autowired
    private CustomerGroupService customerGroupService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GroupJsonUtil groupJsonUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn save(@RequestParam(value = "groupName", required = true) String groupName,
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
        CustomerGroup customerGroupObj = new CustomerGroup();

        try {

            customerGroupObj.setGroupName(groupName);
            customerGroupObj.setDateOfEstablishment(DateUtil.stringToDate(establishment, Formats.DEFAULTDATE));

            Employee employee = employeeService.findByEmployeeId(groupOfficerId);

            if (null != employee) {

                customerGroupObj.setEmployee(employee);

            } else {
                throw new BussinessException("Employee Does Not Exist !");
            }

            customerGroupObj.setMeetingDate(DateUtil.stringToDate(meetingDay, Formats.DEFAULTDATE));
            customerGroupObj.setBranch(groupBranch);
            customerGroupObj.setPrimaryAddress(groupAddress);
            customerGroupObj.setPrimaryContact(contactNumber);
            customerGroupObj.setDescription(details);
            customerGroupObj.setStatus(status);
            customerGroupObj.setAddedBy(username);

            customerGroupService.Save(customerGroupObj);

            jsonReturn.setSuccess("true");
            jsonReturn.setResult(customerGroupObj.getGroupId());
   
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
       

        try {
            
           CustomerGroup object= customerGroupService.findByGroupId(groupId);
            
            if(null!=object){
                
            object.setDateOfEstablishment(DateUtil.stringToDate(establishment, Formats.DEFAULTDATE));

            Employee employee = employeeService.findByEmployeeId(groupOfficerId);

            if (null != employee) {

                object.setEmployee(employee);

            } else {
                throw new BussinessException("Employee Does Not Exist !");
            }

            object.setMeetingDate(DateUtil.stringToDate(meetingDay, Formats.DEFAULTDATE));
            object.setBranch(groupBranch);
            object.setPrimaryAddress(groupAddress);
            object.setPrimaryContact(contactNumber);
            object.setDescription(details);
            object.setStatus(status);
        
            customerGroupService.update(object);
            jsonReturn.setSuccess("true");
            jsonReturn.setResult(object.getGroupId());
            
            }else{
                
                 throw new BussinessException("Group Does Not Exist !");
            }

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
    
    
    

    @RequestMapping(value = "/find/groups", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<GroupJson> findByGroupId() {

        List<CustomerGroup> customerGroup = customerGroupService.findAllGroups();

        return groupJsonUtil.toJson(customerGroup);

    }

}
