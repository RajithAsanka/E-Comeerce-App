package com.nr.fc.service.customer;

import java.util.List;

import com.nr.fc.json.objects.Contact;
import com.nr.fc.model.Customer;

/**
 *
 * @author Naveen
 */
public interface CustomerService {

    /**
     *
     * @param customer
     * @param contactList
     * @param userName
     * @throws Exception
     */
    public void saveNew(Customer customer, List<Contact> contactList, String userName) throws Exception;

    /**
     *
     * Generate student id.
     *
     * @return the string
     */
    public String generateCustomerId();

    /**
     *
     * @param customer
     */
    public void save(Customer customer);

    /**
     *
     * @param customerId
     * @return 
     */
    public Customer findByCustomerId(String customerId);
    
    /**
     * 
     * @param groupId
     * @return 
     */
    public List<Customer>findCustomerByGroupId(String groupId);

}
