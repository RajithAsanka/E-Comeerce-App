/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.service.customergroup;

import com.nr.fc.model.CustomerGroup;
import java.util.List;

/**
 *
 * @author Naveen
 */
public interface CustomerGroupService {

    /**
     *
     * @param customerGroupObj
     */
    public void Save(CustomerGroup customerGroupObj);

    /**
     *
     * @param groupId
     * @return
     */
    public CustomerGroup findByGroupId(String groupId);

    /**
     *
     * @return
     */
    public String getLastGroupID();
    
    
   /**
    * 
    * @return 
    */
    public List<CustomerGroup> findAllGroups();
    
    
    
   public void update(CustomerGroup customerGroupObj);

}
