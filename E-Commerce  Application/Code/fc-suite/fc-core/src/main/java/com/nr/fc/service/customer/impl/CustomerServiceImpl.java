/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.service.customer.impl;

import com.nr.fc.dao.CustomerDao;
import com.nr.fc.enums.GeneralStatus;
import com.nr.fc.json.objects.Contact;
import com.nr.fc.model.Customer;
import com.nr.fc.model.CustomerContact;
import com.nr.fc.model.CustomerContactPK;
import com.nr.fc.model.ImageBank;
import com.nr.fc.service.ImageBankService;
import com.nr.fc.service.ImageTypeService;
import com.nr.fc.service.customer.CustomerContactService;
import com.nr.fc.service.customer.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerContactService customerContactService;

    @Autowired
    private ImageBankService imageBankService;

    @Autowired
    private ImageTypeService imageTypeService;

    @Override
    @Transactional
    public void saveNew(Customer customer, List<Contact> contactList, String userName) throws Exception {

        //save customer
        customer.setCustomerId(generateCustomerId());
        customer.setAddedBy(userName);
        customer.setModifiedBy(userName);
        customer.setAddedDate(new Date());
        customer.setModifiedDate(new Date());
        save(customer);

        // save customer contact
        for (Contact contact : contactList) {
            CustomerContact customerContact = new CustomerContact();
            CustomerContactPK customerContactPK = new CustomerContactPK(customer.getCustomerId(), contact.getContactCategory(), contact.getContactType());
            customerContact.setCustomerContactPK(customerContactPK);
            customerContact.setContact(contact.getContact());
            customerContact.setModifiedBy(userName);
            customerContact.setModifiedDate(new Date());
            customerContact.setAddedBy(userName);
            customerContact.setAddedDate(new Date());
            customerContact.setStatus(GeneralStatus.ACTIVE);
            customerContact.setCustomer(customer);
            customerContactService.save(customerContact);
        }

        //save customer image
        if (customer.getImageId() != null) {
            ImageBank imageBank = customer.getImageId();
            imageBank.setImageTypeId(imageTypeService.findById("JPEG"));
            imageBank.setAddedBy(userName);
            imageBank.setAddedDate(new Date());
            imageBank.setModifiedBy(userName);
            imageBank.setModifiedDate(new Date());
            imageBankService.save(imageBank);
        }

    }

    @Override
    public String generateCustomerId() {
        String sql = "SELECT c FROM Customer c ORDER BY c.customerId DESC ";
        Map<String, Object> params = new HashMap<>();
        List<Customer> customer = customerDao.findbyQueryLimit(sql, params, 1);
        String lastId = "1000000";
        if (customer.size() > 0) {
            lastId = customer.get(0).getCustomerId();
        }
        int intLastId = Integer.parseInt(lastId);
        intLastId++;
        return "" + intLastId;
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        customerDao.create(customer);
    }

    @Override
    public Customer findByCustomerId(String customerId) {
        String sql = "SELECT c FROM Customer c WHERE c.customerId = :customerId";
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", customerId);
        return customerDao.findbyQuerySingle(sql, params);
    }

    @Override
    public List<Customer> findCustomerByGroupId(String groupId) {
        String sql = "SELECT c FROM Customer c WHERE c.groupId.groupId = :groupId";
        Map<String, Object> params = new HashMap<>();
        params.put("groupId", groupId);
        return customerDao.findbyQuery(sql, params);
    }

}
