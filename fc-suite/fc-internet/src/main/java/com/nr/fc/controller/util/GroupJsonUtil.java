/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.controller.util;

import com.nr.fc.json.model.GroupJson;
import com.nr.fc.model.CustomerGroup;
import com.nr.fc.util.DateUtil;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 *
 * @author Naveen
 */
@Component
public class GroupJsonUtil {
    /**
     * 
     * @param group
     * @return 
     */
    public GroupJson toJson(CustomerGroup group) {

        GroupJson groupJson = new GroupJson();
        groupJson.setGroupId(group.getGroupId());
        groupJson.setGroupName(group.getGroupName());
        groupJson.setDateOfEstablishment(DateUtil.dateToString(group.getDateOfEstablishment(), DateUtil.Formats.DEFAULTDATE));
        groupJson.setEmployeeName(group.getEmployee().getFirstName());
        groupJson.setMeetingDate(DateUtil.dateToString(group.getMeetingDate(), DateUtil.Formats.DEFAULTDATE));
        groupJson.setBranch(group.getBranch());
        groupJson.setAddress(group.getPrimaryAddress());
        groupJson.setContact(group.getPrimaryContact());
        groupJson.setDescription(group.getDescription());
        groupJson.setStatus(group.getStatus());

        return groupJson;
    }
    
    
    
    public List<GroupJson> toJson(List<CustomerGroup> group) {

       List<GroupJson> GroupJsonList=new  ArrayList<>();
       
        for (CustomerGroup customerGroup : group) {
            
            
        GroupJson groupJson = new GroupJson();
        groupJson.setGroupId(customerGroup.getGroupId());
        groupJson.setGroupName(customerGroup.getGroupName());
        groupJson.setDateOfEstablishment(DateUtil.dateToString(customerGroup.getDateOfEstablishment(), DateUtil.Formats.DEFAULTDATE));
        groupJson.setEmployeeName(customerGroup.getEmployee().getFirstName());
        groupJson.setMeetingDate(DateUtil.dateToString(customerGroup.getMeetingDate(), DateUtil.Formats.DEFAULTDATE));
        groupJson.setBranch(customerGroup.getBranch());
        groupJson.setAddress(customerGroup.getPrimaryAddress());
        groupJson.setContact(customerGroup.getPrimaryContact());
        groupJson.setDescription(customerGroup.getDescription());
        groupJson.setStatus(customerGroup.getStatus());
        
        GroupJsonList.add(groupJson);
        
        
       }
   
       

        return GroupJsonList;
    }

}
