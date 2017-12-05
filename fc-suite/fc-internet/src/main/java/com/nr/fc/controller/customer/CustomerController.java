/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.controller.customer;

import com.nr.fc.controller.ServicePath;
import com.nr.fc.controller.util.CustomerJsonUtil;
import com.nr.fc.enums.GeneralStatus;
import com.nr.fc.exception.BussinessException;
import com.nr.fc.json.model.CustomerJson;
import com.nr.fc.json.model.JsonReturn;
import com.nr.fc.json.objects.Contact;
import com.nr.fc.model.Customer;
import com.nr.fc.model.CustomerGroup;
import com.nr.fc.model.ImageBank;
import com.nr.fc.service.customer.CustomerService;
import com.nr.fc.service.customergroup.CustomerGroupService;
import com.nr.fc.util.DateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Naveen
 */
@Controller
@RequestMapping(value = ServicePath.ADMIN_PREFIX + ServicePath.CREATE_CUSTOMER)
public class CustomerController {
    
     @Autowired
    private CustomerGroupService customerGroupService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerJsonUtil customerJsonUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn save(
            @RequestParam(value = "groupId", required = false) String groupId,
            @RequestParam(value = "nationalID", required = false) String nationalID,
            @RequestParam(value = "idType", required = false) String idType,
            @RequestParam(value = "txtPersonalAddress1", required = false) String txtPersonalAddress1,
            @RequestParam(value = "txtPersonalAddress2", required = false) String txtPersonalAddress2,
            @RequestParam(value = "sltPersonalProvince", required = false) String sltPersonalProvince,
            @RequestParam(value = "sltPersonalCity", required = false) String sltPersonalCity,
            @RequestParam(value = "salutaionId", required = false) String salutaionId,
            @RequestParam(value = "sltGender", required = false) String sltGender,
            @RequestParam(value = "txtFirstName", required = false) String txtFirstName,
            @RequestParam(value = "txtMiddleName", required = false) String txtMiddleName,
            @RequestParam(value = "txtLastName", required = false) String txtLastName,
            @RequestParam(value = "txtDob", required = false) String txtDob,
            @RequestParam(value = "occupation", required = false) String occupation,
            @RequestParam(value = "noFamily", required = false) String noFamily,
            @RequestParam(value = "noDependents", required = false) String noDependents,
            @RequestParam(value = "issuedCountry", required = false) String issuedCountry,
            @RequestParam(value = "chkActive", required = false) String chkActive,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "fileUpload", required = false) String fileUpload,
            @RequestParam(value = "phoneNoOne", required = false) String phoneNoOne,
            @RequestParam(value = "phoneNoTwo", required = false) String phoneNoTwo,
            @RequestParam(value = "landLine", required = false) String landLine,
            @RequestParam(value = "personalEmail", required = false) String personalEmail,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "fax", required = false) String fax) {

        JsonReturn jsonReturn = new JsonReturn();
        Customer customer = new Customer();
        List<Contact> contactList = new ArrayList<>();
        try {

            CustomerGroup customerGroup= customerGroupService.findByGroupId(groupId);
            
            if(null!=customerGroup){
                
                 customer.setGroupId(customerGroup);
                
            }else{
                
                  throw new BussinessException("Group Does Not Exist !");
            }
              
            customer.setSalutaionId(salutaionId);
            customer.setFirstName(txtFirstName);
            customer.setMiddleName(txtMiddleName);
            customer.setLastName(txtLastName);
            customer.setDateOfBirth(DateUtil.stringToDate(txtDob, DateUtil.Formats.DEFAULTDATE));

            customer.setIdType(idType);
            customer.setCustomerIdentificationNo(nationalID);
            customer.setIssudeCountry(issuedCountry);
            customer.setOccupation(occupation);
            customer.setNoOfFamilyMembers(noFamily);
            customer.setNoOfDependents(noDependents);

            customer.setFirstAddress(txtPersonalAddress1);
            customer.setSecondAddress(txtPersonalAddress2);
            customer.setCity(sltPersonalCity);
            customer.setProvince(sltPersonalProvince);

            customer.setStatus(chkActive);

            // setting gender
            if (sltGender.equalsIgnoreCase("male")) {
                customer.setGender("1");
            } else if (sltGender.equalsIgnoreCase("female")) {
                customer.setGender("0");
            }

            // student picture
            if (!StringUtils.isEmpty(fileUpload)) {
                customer.setImageId(new ImageBank("", fileUpload, GeneralStatus.ACTIVE.toString(), new Date(), username));
            }

            // Setting Contacts
            if (!StringUtils.isEmpty(phoneNoOne)) {
                contactList.add(new Contact("", "Primary", "Telephone", phoneNoOne));
            }
            if (!StringUtils.isEmpty(landLine)) {
                contactList.add(new Contact("", "Primary", "Land Line", landLine));
            }
            if (!StringUtils.isEmpty(personalEmail)) {
                contactList.add(new Contact("", "Primary", "Email", personalEmail));
            }
            if (!StringUtils.isEmpty(phoneNoTwo)) {
                contactList.add(new Contact("", "Normal", "Telephone", phoneNoTwo));
            }
            if (!StringUtils.isEmpty(email)) {
                contactList.add(new Contact("", "Normal", "Email", email));
            }
            if (!StringUtils.isEmpty(fax)) {
                contactList.add(new Contact("", "Normal", "Fax", fax));
            }

            customerService.saveNew(customer, contactList, username);

            jsonReturn.setSuccess("true");
            jsonReturn.setResult(customer.getCustomerId());

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

    @RequestMapping(value = "/find/custormerId", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public CustomerJson findByCustomerId(@RequestParam(value = "custormerId", required = true) String custormerId) {

        Customer customer = customerService.findByCustomerId(custormerId);

        return customerJsonUtil.toJson(customer);

    }
    
    
    @RequestMapping(value = "/find/groupId", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<CustomerJson> findCustomerByGroupId(@RequestParam(value = "groupId", required = true) String groupId) {

        List<Customer> customer = customerService.findCustomerByGroupId(groupId);

        return customerJsonUtil.toJson(customer);

    }

}
