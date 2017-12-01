/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.service.customer.impl;

import com.nr.fc.dao.CustomerContactDao;
import com.nr.fc.model.CustomerContact;
import com.nr.fc.model.CustomerContactPK;
import com.nr.fc.service.customer.CustomerContactService;
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
public class CustomerContactServiceImpl implements CustomerContactService {

    @Autowired
    private CustomerContactDao customerContactDao;

    @Override
    @Transactional
    public void save(CustomerContact customerContact) {

        customerContactDao.create(customerContact);
    }

    @Override
    public CustomerContact findByPk(CustomerContactPK customerContactPK) {
        return customerContactDao.read(customerContactPK);
    }

    @Override
    public List<CustomerContact> findByCustomerId(String customerId) {
        String sql = "SELECT c FROM CustomerContact c WHERE c.customerContactPK.customerId = :customerId";
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", customerId);
        return customerContactDao.findbyQuery(sql, params);
    }

}
