/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.service.customergroup.impl;

import com.nr.fc.dao.CustomerGroupDao;
import com.nr.fc.model.CustomerGroup;
import com.nr.fc.service.customergroup.CustomerGroupService;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Naveen
 */
@Service
public class CustomerGroupServiceImpl implements CustomerGroupService {

    @Autowired
    private CustomerGroupDao customerGroupDao;

    @Override
    @Transactional
    public void Save(CustomerGroup customerGroupObj) {
        customerGroupObj.setGroupId(getLastGroupID());
        customerGroupObj.setAddedDate(new Date());
        customerGroupObj.setModifiedDate(new Date());
        customerGroupObj.setModifiedBy(customerGroupObj.getAddedBy());
        customerGroupDao.create(customerGroupObj);
    }

    @Override
    public String getLastGroupID() {
        String sql = "SELECT c FROM CustomerGroup c ORDER BY c.groupId DESC ";
        List<CustomerGroup> findNamedQueryLimit = customerGroupDao.findbyQuery(sql, new HashMap<String, Object>());

        String prefix = "GRP";
        String firstid = "001";
        int index = 0;
        String lastGroupID = null;

        if (!findNamedQueryLimit.isEmpty()) {

            lastGroupID = findNamedQueryLimit.get(0).getGroupId();

            for (int i = 0; i < lastGroupID.length(); i++) {
                char c = lastGroupID.charAt(i);
                if (Character.isDigit(c)) {
                    index = i;
                    break;
                }
            }
            int newidNumber = Integer.parseInt(lastGroupID.substring(index)) + 1;
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);

            String lastId = prefix + numberFormat.format(newidNumber);
            return lastId;
        } else {
            return prefix + firstid;
        }
    }

    @Override
    public CustomerGroup findByGroupId(String groupId) {
        String sql = "SELECT a FROm CustomerGroup a WHERE a.groupId=:groupId";
        Map<String, Object> params = new HashMap<>();
        params.put("groupId", groupId);
        return customerGroupDao.findbyQuerySingle(sql, params);
    }

    @Override
    public List<CustomerGroup> findAllGroups() {
        
        return customerGroupDao.findAll();
    }
    /**
     * 
     * @param customerGroupObj 
     */
    @Override
    @Transactional
    public void update(CustomerGroup customerGroupObj) {
        
        
        customerGroupObj.setModifiedDate(new Date());
        customerGroupObj.setModifiedBy(customerGroupObj.getAddedBy());
        customerGroupDao.update(customerGroupObj);
    }

}
