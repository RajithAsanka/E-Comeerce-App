/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.controller.util;

import com.nr.fc.json.model.CustomerJson;
import com.nr.fc.model.Customer;
import com.nr.fc.model.CustomerContact;
import com.nr.fc.service.customer.CustomerContactService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Naveen
 */
@Component
public class CustomerJsonUtil {

    @Autowired
    private CustomerContactService customerContactService;

    public CustomerJson toJson(Customer customer) {

        CustomerJson customerJson = new CustomerJson();
        customerJson.setCustomerId(customer.getCustomerId());
        customerJson.setSalutaionId(customer.getSalutaionId());
        customerJson.setFirstName(customer.getFirstName());
        customerJson.setMiddleName(customer.getMiddleName());
        customerJson.setLastName(customer.getLastName());
        customerJson.setGender(customer.getGender());
        customerJson.setIdType(customer.getIdType());
        customerJson.setMemberName(customer.getSalutaionId()+" "+customer.getFirstName()+" "+customer.getLastName());
        customerJson.setCustomerIdentificationNumber(customer.getCustomerIdentificationNo());
        customerJson.setIssueCountry(customer.getIssudeCountry());
        customerJson.setOccupation(customer.getOccupation());
        customerJson.setNoOfFamilyMembers(customer.getNoOfFamilyMembers());
        customerJson.setNoOfDependents(customer.getNoOfDependents());
        customerJson.setFirstAddress(customer.getFirstAddress());
        customerJson.setSecondAddress(customer.getSecondAddress());
        customerJson.setCity(customer.getCity());
        customerJson.setProvince(customer.getProvince());
        //customerJson.setImageId(customer.geti);
        customerJson.setStatus(customer.getStatus());

        List<CustomerContact> contactsList = customerContactService.findByCustomerId(customer.getCustomerId());

        for (CustomerContact contactsListobject : contactsList) {

            if (contactsListobject.getCustomerContactPK().getContactCategory().equalsIgnoreCase("primary") && contactsListobject.getCustomerContactPK().getContactType().equalsIgnoreCase("telephone")) {
                customerJson.setMobileNumberOne(contactsListobject.getContact());
            }

            if (contactsListobject.getCustomerContactPK().getContactCategory().equalsIgnoreCase("primary") && contactsListobject.getCustomerContactPK().getContactType().equalsIgnoreCase("land line")) {
                customerJson.setLandLineNumber(contactsListobject.getContact());
            }

            if (contactsListobject.getCustomerContactPK().getContactCategory().equalsIgnoreCase("primary") && contactsListobject.getCustomerContactPK().getContactType().equalsIgnoreCase("email")) {
                customerJson.setPersonalEmail(contactsListobject.getContact());
            }

            if (contactsListobject.getCustomerContactPK().getContactCategory().equalsIgnoreCase("normal") && contactsListobject.getCustomerContactPK().getContactType().equalsIgnoreCase("telephone")) {
                customerJson.setMobileNumberTwo(contactsListobject.getContact());
            }

            if (contactsListobject.getCustomerContactPK().getContactCategory().equalsIgnoreCase("normal") && contactsListobject.getCustomerContactPK().getContactType().equalsIgnoreCase("email")) {
                customerJson.setEmail(contactsListobject.getContact());
            }

            if (contactsListobject.getCustomerContactPK().getContactCategory().equalsIgnoreCase("normal") && contactsListobject.getCustomerContactPK().getContactType().equalsIgnoreCase("fax")) {
                customerJson.setFax(contactsListobject.getContact());
            }

        }
        return customerJson;

    }
    
    
     public List<CustomerJson> toJson(List<Customer> customer) {

      List<CustomerJson> customerJsonList = new  ArrayList<>();
         
      for (Customer customerObj : customer) {
             
        CustomerJson customerJson = new CustomerJson();
        
        customerJson.setCustomerId(customerObj.getCustomerId());
        customerJson.setSalutaionId(customerObj.getSalutaionId());
        customerJson.setFirstName(customerObj.getFirstName());
        customerJson.setMiddleName(customerObj.getMiddleName());
        customerJson.setLastName(customerObj.getLastName());
        customerJson.setGender(customerObj.getGender());
        customerJson.setIdType(customerObj.getIdType());
        customerJson.setMemberName(customerObj.getSalutaionId()+" "+customerObj.getFirstName()+" "+customerObj.getLastName());
        customerJson.setCustomerIdentificationNumber(customerObj.getCustomerIdentificationNo());
        customerJson.setIssueCountry(customerObj.getIssudeCountry());
        customerJson.setOccupation(customerObj.getOccupation());
        customerJson.setNoOfFamilyMembers(customerObj.getNoOfFamilyMembers());
        customerJson.setNoOfDependents(customerObj.getNoOfDependents());
        customerJson.setFirstAddress(customerObj.getFirstAddress());
        customerJson.setSecondAddress(customerObj.getSecondAddress());
        customerJson.setCity(customerObj.getCity());
        customerJson.setProvince(customerObj.getProvince());
        //customerJson.setImageId(customer.geti);
        customerJson.setStatus(customerObj.getStatus());

        List<CustomerContact> contactsList = customerContactService.findByCustomerId(customerObj.getCustomerId());

        for (CustomerContact contactsListobject : contactsList) {

            if (contactsListobject.getCustomerContactPK().getContactCategory().equalsIgnoreCase("primary") && contactsListobject.getCustomerContactPK().getContactType().equalsIgnoreCase("telephone")) {
                customerJson.setMobileNumberOne(contactsListobject.getContact());
            }

            if (contactsListobject.getCustomerContactPK().getContactCategory().equalsIgnoreCase("primary") && contactsListobject.getCustomerContactPK().getContactType().equalsIgnoreCase("land line")) {
                customerJson.setLandLineNumber(contactsListobject.getContact());
            }

            if (contactsListobject.getCustomerContactPK().getContactCategory().equalsIgnoreCase("primary") && contactsListobject.getCustomerContactPK().getContactType().equalsIgnoreCase("email")) {
                customerJson.setPersonalEmail(contactsListobject.getContact());
            }

            if (contactsListobject.getCustomerContactPK().getContactCategory().equalsIgnoreCase("normal") && contactsListobject.getCustomerContactPK().getContactType().equalsIgnoreCase("telephone")) {
                customerJson.setMobileNumberTwo(contactsListobject.getContact());
            }

            if (contactsListobject.getCustomerContactPK().getContactCategory().equalsIgnoreCase("normal") && contactsListobject.getCustomerContactPK().getContactType().equalsIgnoreCase("email")) {
                customerJson.setEmail(contactsListobject.getContact());
            }

            if (contactsListobject.getCustomerContactPK().getContactCategory().equalsIgnoreCase("normal") && contactsListobject.getCustomerContactPK().getContactType().equalsIgnoreCase("fax")) {
                customerJson.setFax(contactsListobject.getContact());
            }

        }
        
            customerJsonList.add(customerJson);
      }
         
         
        return customerJsonList;

    }

}
