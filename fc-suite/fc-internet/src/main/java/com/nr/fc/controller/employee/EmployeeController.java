package com.nr.fc.controller.employee;

///*
// * To change this license header, choose License Headers in Project Properties. To change this
// * template file, choose Tools | Templates and open the template in the editor.
// */
//package com.nr.fc.controller.employee;
//
//import javax.servlet.ServletContext;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.context.ServletContextAware;
//
//import com.nr.fc.controller.ServicePath;
//import com.nr.fc.controller.common.CommonCrud;
//import com.nr.fc.criteria.EmployeeCriteria;
//import com.nr.fc.enums.GeneralStatus;
//import com.nr.fc.json.objects.Contact;
//import com.nr.fc.json.model.EmployeeAreaOfExpertiseActivityJson;
//import com.nr.fc.json.model.EmployeeEducationQualificationJson;
//import com.nr.fc.json.model.EmployeeHistoryJson;
//import com.nr.fc.json.model.EmployeeJson;
//import com.nr.fc.json.model.EmployeeTrainingJson;
//import com.nr.fc.json.model.JsonReturn;
//import com.nr.fc.json.model.JsonReturn.successValue;
//import com.nr.fc.json.model.ReportToEmployeeDetailJson;
//import com.nr.fc.model.AddressType;
//import com.nr.fc.model.City;
//import com.nr.fc.model.CityPK;
//import com.nr.fc.model.Employee;
//import com.nr.fc.model.EmployeeAddress;
//import com.nr.fc.model.EmployeeAddressPK;
//import com.nr.fc.model.EmployeeAreaOfExpertiseActivityLink;
//import com.nr.fc.model.EmployeeContact;
//import com.nr.fc.model.EmployeeHistory;
//import com.nr.fc.model.EmployeeLanguageLink;
//import com.nr.fc.model.EmployeeQualificationLink;
//import com.nr.fc.model.EmployeeTraining;
//import com.nr.fc.model.ImageBank;
//import com.nr.fc.model.ReportingToDetail;
//import com.nr.fc.model.ReportingToDetailPK;
//import com.nr.fc.service.employee.EmployeeAddressService;
//import com.nr.fc.service.employee.EmployeeAreaOfExpertiseActivityLinkService;
//import com.nr.fc.service.employee.EmployeeContactService;
//import com.nr.fc.service.employee.EmployeeEducationService;
//import com.nr.fc.service.employee.EmployeeHistoryService;
//import com.nr.fc.service.employee.EmployeeLanguageLinkService;
//import com.nr.fc.service.employee.EmployeeService;
//import com.nr.fc.service.employee.EmployeeTrainingService;
//import com.nr.fc.service.ImageBankService;
//import com.nr.fc.service.InstituteService;
//import com.nr.fc.service.ReportingToDetailService;
//import com.nr.fc.util.DateUtil;
//import com.nr.fc.util.DateUtil.Formats;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import java.lang.reflect.Type;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@RequestMapping(value = ServicePath.ADMIN_PREFIX + ServicePath.EMPLOYEE)
//public class EmployeeController extends CommonCrud implements ServletContextAware {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
//
//    private ServletContext servletContext;
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private EmployeeAddressService employeeAddressService;
//
//    @Autowired
//    private EmployeeContactService employeeContactService;
//
//    @Autowired
//    private EmployeeAreaOfExpertiseActivityLinkService employeeAreaOfExpertiseActivityLinkService;
//
//    @Autowired
//    private EmployeeEducationService employeeEducationService;
//
//    @Autowired
//    private InstituteService instituteService;
//
//    @Autowired
//    private EmployeeTrainingService employeeTrainingService;
//
//    @Autowired
//    private ReportingToDetailService reportingToDetailService;
//
//    @Autowired
//    private EmployeeHistoryService employeeHistoryService;
//
//    @Autowired
//    private ImageBankService imageBankService;
//
//    @Autowired
//    private EmployeeLanguageLinkService languageLinkService;
//
//    // ###### CRUD ACTIONS ######################################################
//    /**
//     * Save employee
//     *
//     * @param employeeRegNumber
//     * @param salutation
//     * @param dateOfJoined
//     * @param firstName
//     * @param middleName
//     * @param lastName
//     * @param dateOfBirth
//     * @param gender
//     * @param maritalStatus
//     * @param idNo
//     * @param idType
//     * @param nicNo
//     * @param passportNo
//     * @param drivingLicenceNo
//     * @param birthPlace
//     * @param noofChildren
//     * @param bloodGroup
//     * @param nationlity
//     * @param religion
//     * @param language
//     * @param status
//     * @param personalAddress1
//     * @param personaladdress2
//     * @param personalcountry
//     * @param personalProvince
//     * @param personalCity
//     * @param department
//     * @param employeeCategory
//     * @param phoneNoOne
//     * @param phoneNoTwo
//     * @param personalEmail
//     * @param email
//     * @param fax
//     * @param jobTitle
//     * @param contractEndDate
//     * @param file
//     * @param reportingToList
//     * @param userName
//     * @param servletRequest
//     * @return
//     */
//    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
//    @ResponseBody
//    public JsonReturn save(@RequestParam(value = "employeeRegNumber", required = true) String employeeRegNumber,
//            @RequestParam(value = "saluataion", required = true) String salutation,
//            @RequestParam(value = "dateOfJoined", required = true) String dateOfJoined,
//            @RequestParam(value = "firstName", required = true) String firstName,
//            @RequestParam(value = "middleName", required = false) String middleName,
//            @RequestParam(value = "lastName", required = true) String lastName,
//            @RequestParam(value = "dateOfBirth", required = true) String dateOfBirth,
//            @RequestParam(value = "gender", required = true) String gender,
//            @RequestParam(value = "maritalStatus", required = true) String maritalStatus,
//            @RequestParam(value = "idNo", required = true) String idNo,
//            @RequestParam(value = "idType", required = true) String idType,
//            @RequestParam(value = "birthPlace", required = true) String birthPlace,
//            @RequestParam(value = "noOfChildren", required = false) String noofChildren,
//            @RequestParam(value = "bloodGroup", required = true) String bloodGroup,
//            @RequestParam(value = "nationality", required = true) String nationlity,
//            @RequestParam(value = "religion", required = true) String religion,
//            @RequestParam(value = "language1", required = true) String language1,
//            @RequestParam(value = "language2", required = true) String language2,
//            @RequestParam(value = "personalStreetAddress1", required = true) String personalAddress1,
//            @RequestParam(value = "personalStreetAddress2", required = false) String personaladdress2,
//            @RequestParam(value = "personalCountry", required = true) String personalcountry,
//            @RequestParam(value = "personalProvince", required = true) String personalProvince,
//            @RequestParam(value = "personalCity", required = true) String personalCity,
//            @RequestParam(value = "department", required = true) String department,
//            @RequestParam(value = "employeeCategory", required = true) String employeeCategory,
//            @RequestParam(value = "jobTitle", required = true) String jobTitle,
//            @RequestParam(value = "phoneNoOne", required = true) String phoneNoOne,
//            @RequestParam(value = "phoneNoTwo", required = false) String phoneNoTwo,
//            @RequestParam(value = "personalEmail", required = false) String personalEmail,
//            @RequestParam(value = "email", required = false) String email,
//            @RequestParam(value = "fax", required = false) String fax,
//            @RequestParam(value = "status", required = true) String status,
//            @RequestParam(value = "contractEndDate", required = false) String contractEndDate,
//            @RequestParam(value = "fileUpload", required = false) String file,
//            @RequestParam(value = "reportingToList", required = false) String reportingToList,
//            @RequestParam(value = "username", required = true) String userName, HttpServletRequest servletRequest) {
//
//        JsonReturn jsonReturn = new JsonReturn();
//        List<EmployeeJson> employeeReportList = new ArrayList<>();
//
//        try {
//
//            // create new employee
//            Employee employee = new Employee();
//            String generateEmployeeId = employeeService.generateEmployeeId();
//            employee.setEmployeeId(generateEmployeeId);
//            employee.setEmployeeRegistrationNo(employeeRegNumber);
//            employee.setEmployeeCategoryId(employeeCategoryService.findByEmployeeCategoryId(employeeCategory));
//            employee.setJobTitle(jobTitleService.findById(jobTitle));
//            employee.setDepartmentId(departmentService.findById(department));
//            employee.setNationalityId(nationalityService.findById(nationlity));
//            employee.setReligionId(religionService.findById(religion));
//            employee.setSalutaionId(salutation);
//            employee.setFirstName(firstName);
//            employee.setMiddleName(middleName);
//            employee.setLastName(lastName);
//            employee.setDateOfBirth(DateUtil.stringToDate(dateOfBirth, Formats.DEFAULTDATE));
//            if (gender.equalsIgnoreCase("Male")) {
//                employee.setGender("1");
//            } else {
//                employee.setGender("0");
//            }
//
//            if (employeeCategory.equals("Contract based")) {
//                employee.setContract(employeeCategory);
//                employee.setContractEndDate(DateUtil.stringToDate(contractEndDate, Formats.DEFAULTDATE));
//            } else {
//                employee.setContract(employeeCategory);
//            }
//            employee.setMaritalStatus(maritalStatus);
//            employee.setNoOfChildren(noofChildren);
//            employee.setBloodGroupId(bloodGroup);
//            employee.setDateJoined(DateUtil.stringToDate(dateOfJoined, Formats.DEFAULTDATE));
//            employee.setBirthPlace(birthPlace);
//
//            switch (idType) {
//                case "NRIC":
//                    employee.setNicNo(idNo);
//                    break;
//                case "Passport":
//                    employee.setPassportNo(idNo);
//                    break;
//                case "Driving Licence":
//                    employee.setDrivingLicenceNo(idNo);
//                    break;
//            }
//
//            employee.setDescription("");
//            employee.setModifiedBy(userName);
//            employee.setModifiedDate(new Date());
//            employee.setAddedBy(userName);
//            employee.setAddedDate(new Date());
//            employee.setStatus(status);
//
//            if (!StringUtils.isEmpty(file)) {
//                employee.setImageId(new ImageBank(employee.getEmployeeId(), file, GeneralStatus.ACTIVE, new Date(), userName));
//            }
//
//            if (!reportingToList.isEmpty()) {
//                employeeReportList = convertEmploeeString(reportingToList);
//            }
//            List<EmployeeAddress> employeeAddressList = new ArrayList<>();
//
//            AddressType addressType = addressTypeService.findbyId("Personal");
//            EmployeeAddress personnelAddress = new EmployeeAddress();
//            personnelAddress.setAddressType1(addressType);
//            // #### Personel Address #####
//            CityPK cityPK = new CityPK(personalCity, personalProvince, personalcountry);
//            City city = cityService.findByPK(cityPK);
//            //  
//            personnelAddress.setCity(city);
//            personnelAddress.setStreetAddress1(personalAddress1);
//            personnelAddress.setStreetAddress2(personaladdress2);
//            employeeAddressList.add(personnelAddress);
//
//            if (!employee.getEmployeeRegistrationNo().isEmpty() && !employee.getEmployeeId().isEmpty()) {
//
//                Employee employeeobj = employeeService.findByRegistrationId(employee.getEmployeeRegistrationNo());
//
//                if (employeeobj != null) {
//                    jsonReturn.setSuccess("false");
//                    jsonReturn.setErrorMessage("Already exist " + employee.getEmployeeRegistrationNo());
//                } else {
//
//                    List<Contact> employeeContactList = getEmployeeContactList(employee, phoneNoOne, personalEmail, phoneNoTwo, email, fax);
//                    // save employee
//                    employeeService.save(employee, language1, language2, employeeContactList, employeeAddressList, employeeReportList, userName);
//                    // retun success
//                    jsonReturn.setSuccess("true");
//                    jsonReturn.setResult(employee.getEmployeeId());
//                }
//            }
//        } catch (ConstraintViolationException e) {
//            for (ConstraintViolation<?> obj : e.getConstraintViolations()) {
//                /*
//                 * System.out.println(obj.getRootBeanClass().getName());
//                 * System.out.println(obj.getPropertyPath()); System.out.println(obj.getInvalidValue());
//                 * System.out.println(obj.getConstraintDescriptor()); System.out.println(obj.getMessage());
//                 */
//                LOGGER.error(obj.getPropertyPath() + obj.getMessage());
//            }
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage());
//            jsonReturn.setSuccess("false");
//            jsonReturn.setErrorMessage(e.getMessage());
//            jsonReturn.setErrorCode("123");
//        }
//        return jsonReturn;
//    }
//
//    // ###### Update
//    // ACTIONS#####################################################
//    @RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
//    @ResponseBody
//    public JsonReturn updateDetail(@RequestParam(value = "employeeRegNumber", required = true) String employeeRegNumber,
//            @RequestParam(value = "employeeId", required = true) String employeeId,
//            @RequestParam(value = "saluataion", required = true) String salutation,
//            @RequestParam(value = "dateOfJoined", required = true) String dateOfJoined,
//            @RequestParam(value = "firstName", required = true) String firstName,
//            @RequestParam(value = "middleName", required = false) String middleName,
//            @RequestParam(value = "lastName", required = true) String lastName,
//            @RequestParam(value = "dateOfBirth", required = true) String dateOfBirth,
//            @RequestParam(value = "gender", required = true) String gender,
//            @RequestParam(value = "maritalStatus", required = true) String maritalStatus,
//            @RequestParam(value = "idNo", required = true) String idNo,
//            @RequestParam(value = "idType", required = true) String idType,
//            @RequestParam(value = "birthPlace", required = true) String birthPlace,
//            @RequestParam(value = "noOfChildren", required = false) String noofChildren,
//            @RequestParam(value = "bloodGroup", required = true) String bloodGroup,
//            @RequestParam(value = "nationality", required = true) String nationlity,
//            @RequestParam(value = "religion", required = true) String religion,
//            @RequestParam(value = "language1", required = true) String language1,
//            @RequestParam(value = "language2", required = true) String language2,
//            @RequestParam(value = "personalStreetAddress1", required = true) String personalAddress1,
//            @RequestParam(value = "personalStreetAddress2", required = false) String personaladdress2,
//            @RequestParam(value = "personalCountry", required = true) String personalcountry,
//            @RequestParam(value = "personalProvince", required = true) String personalProvince,
//            @RequestParam(value = "personalCity", required = true) String personalCity,
//            @RequestParam(value = "department", required = true) String department,
//            @RequestParam(value = "employeeCategory", required = true) String employeeCategory,
//            @RequestParam(value = "jobTitle", required = true) String jobTitle,
//            @RequestParam(value = "phoneNoOne", required = true) String phoneNoOne,
//            @RequestParam(value = "phoneNoTwo", required = false) String phoneNoTwo,
//            @RequestParam(value = "personalEmail", required = false) String personalEmail,
//            @RequestParam(value = "email", required = false) String email,
//            @RequestParam(value = "fax", required = false) String fax,
//            @RequestParam(value = "status", required = true) String status,
//            @RequestParam(value = "contractEndDate", required = false) String contractEndDate,
//            @RequestParam(value = "fileUpload", required = false) String file,
//            @RequestParam(value = "reportingToList", required = false) String reportingToList,
//            @RequestParam(value = "username", required = true) String userName, HttpServletRequest servletRequest) {
//
//        JsonReturn jsonReturn = new JsonReturn();
//        List<EmployeeJson> employeeReportList = new ArrayList<>();
//
//        try {
//
//            Employee employee = employeeService.findByEmployeeId(employeeId);
//            employee.setEmployeeRegistrationNo(employeeRegNumber);
//
//            if (employeeCategory.equals("Contract based")) {
//                employee.setEmployeeCategoryId(employeeCategoryService.findByEmployeeCategoryId(employeeCategory));
//                employee.setContractEndDate(DateUtil.stringToDate(contractEndDate, Formats.DEFAULTDATE));
//            } else {
//                employee.setEmployeeCategoryId(employeeCategoryService.findByEmployeeCategoryId(employeeCategory));
//                employee.setContractEndDate(null);
//
//            }
//
//            employee.setJobTitle(jobTitleService.findById(jobTitle));
//            employee.setDepartmentId(departmentService.findById(department));
//            employee.setNationalityId(nationalityService.findById(nationlity));
//            employee.setReligionId(religionService.findById(religion));
//            employee.setSalutaionId(salutation);
//            employee.setFirstName(firstName);
//            employee.setMiddleName(middleName);
//            employee.setLastName(lastName);
//            employee.setDateOfBirth(DateUtil.stringToDate(dateOfBirth, Formats.DEFAULTDATE));
//            if (gender.equalsIgnoreCase("Male")) {
//                employee.setGender("1");
//            } else {
//                employee.setGender("0");
//            }
//
//            employee.setMaritalStatus(maritalStatus);
//            employee.setNoOfChildren(noofChildren);
//            employee.setBloodGroupId(bloodGroup);
//            employee.setDateJoined(DateUtil.stringToDate(dateOfJoined, Formats.DEFAULTDATE));
//            employee.setBirthPlace(birthPlace);
//
//            switch (idType) {
//                case "NRIC":
//                    employee.setNicNo(idNo);
//                    break;
//                case "Passport":
//                    employee.setPassportNo(idNo);
//                    break;
//                case "Driving Licence":
//                    employee.setDrivingLicenceNo(idNo);
//                    break;
//            }
//            employee.setDescription("");
//            employee.setModifiedBy(userName);
//            employee.setModifiedDate(new Date());
//            employee.setAddedBy(userName);
//            employee.setAddedDate(new Date());
//            employee.setStatus(status);
//
//            if (!StringUtils.isEmpty(file)) {
//                employee.setImageId(new ImageBank(employee.getEmployeeId(), file, GeneralStatus.ACTIVE, new Date(), userName));
//            }
//
//            if (!reportingToList.isEmpty()) {
//                employeeReportList = convertEmploeeString(reportingToList);
//            }
//            List<EmployeeAddress> employeeAddressList = new ArrayList<>();
//
//            AddressType addressType = addressTypeService.findbyId("Personal");
//            EmployeeAddress personnelAddress = employeeAddressService.findByPk(new EmployeeAddressPK(employeeId, addressType.getAddressType()));
//
//            // #### Personel Address #####
//            CityPK cityPK = new CityPK(personalCity, personalProvince, personalcountry);
//            City city = cityService.findByPK(cityPK);
//            //  
//            personnelAddress.setCity(city);
//            personnelAddress.setStreetAddress1(personalAddress1);
//            personnelAddress.setStreetAddress2(personaladdress2);
//            employeeAddressList.add(personnelAddress);
//
//            List<Contact> employeeContactList = getEmployeeContactList(employee, phoneNoOne, personalEmail, phoneNoTwo, email, fax);
//
//            // Contact Lis add
//            employeeService.update(employee, language1, language2, employeeContactList, employeeAddressList, employeeReportList, userName);
//            // retun success
//            jsonReturn.setSuccess("true");
//            jsonReturn.setResult(employee.getEmployeeId());
//
//        } catch (ConstraintViolationException e) {
//            for (ConstraintViolation<?> obj : e.getConstraintViolations()) {
//                /*
//                 * System.out.println(obj.getRootBeanClass().getName());
//                 * System.out.println(obj.getPropertyPath()); System.out.println(obj.getInvalidValue());
//                 * System.out.println(obj.getConstraintDescriptor()); System.out.println(obj.getMessage());
//                 */
//                LOGGER.error(obj.getPropertyPath() + obj.getMessage());
//            }
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage());
//            jsonReturn.setSuccess("false");
//            jsonReturn.setErrorMessage(e.getMessage());
//            jsonReturn.setErrorCode("123");
//        }
//        return jsonReturn;
//    }
//
//    @RequestMapping(value = "/find/json", method = RequestMethod.GET, headers = "Accept=application/json")
//    @ResponseBody
//    public List<EmployeeJson> searchJson(
//            @RequestParam(value = "name", required = false) String name,
//            @RequestParam(value = "regNo", required = false) String regNo,
//            @RequestParam(value = "joiningDate", required = false) String joiningDate,
//            @RequestParam(value = "category", required = false) String category,
//            @RequestParam(value = "birthPlace", required = false) String birthPlace,
//            @RequestParam(value = "dob", required = false) String dob,
//            @RequestParam(value = "nricNo", required = false) String nricNo,
//            @RequestParam(value = "drivingLNo", required = false) String drivingLNo,
//            @RequestParam(value = "passportNo", required = false) String passportNo) {
//
//        EmployeeCriteria criteria = new EmployeeCriteria();
//        try {
//
//            criteria.setRegNo(regNo);
//            String[] splitNames = name.split(" ");
//
//            if (splitNames.length > 1) {
//                for (int i = 0; i < splitNames.length; i++) {
//                    if (i == 0) {
//                        criteria.setFirstName(splitNames[i]);
//                        criteria.setMiddleName(splitNames[i]);
//                    }
//                    if (i == 1) {
//                        criteria.setMiddleName(splitNames[i]);
//                        criteria.setLastName(splitNames[i]);
//                    }
//                    if (i == 2) {
//                        criteria.setLastName(splitNames[i]);
//                    }
//                }
//            } else {
//                criteria.setName(name);
//            }
//
//            if (joiningDate != null) {
//                criteria.setJoiningDate(DateUtil.stringToDate(joiningDate, Formats.DEFAULTDATE));
//            }
//            criteria.setCategory(category);
//            criteria.setBirthPlace(birthPlace);
//            if (dob != null) {
//                criteria.setDob(DateUtil.stringToDate(dob, Formats.DEFAULTDATE));
//            }
//            criteria.setDrivingLNo(drivingLNo);
//            criteria.setPassportNo(passportNo);
//            criteria.setNricNo(nricNo);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//            LOGGER.error("employee search()" + e.getMessage());
//        }
//
//        return toJson(employeeService.findByCriteria(criteria));
//
//    }
//
//    private List<EmployeeJson> convertEmploeeString(String jsonString) throws Exception {
//        Gson gson = new Gson();
//        Type employeeJson = new TypeToken<List<EmployeeJson>>() {
//        }.getType();
//        List<EmployeeJson> employeJsons = gson.fromJson(jsonString, employeeJson);
//        return employeJsons;
//    }
//
//    @Override
//    public void setServletContext(ServletContext servletContext) {
//        this.servletContext = servletContext;
//    }
//
//    @RequestMapping(value = "/find/employeeId", method = RequestMethod.GET, headers = "Accept=application/json")
//    @ResponseBody
//    public EmployeeJson findByEmployeeId(@RequestParam(value = "employeeId", required = false) String employeeId) {
//
//        return toJson(employeeService.findByEmployeeId(employeeId));
//    }
//
//    // ###### OTHER ACTIONS #####################################################
//    public EmployeeJson toJson(Employee employee) {
//
//        EmployeeJson employeeDetailsJson = new EmployeeJson();
//
//        employeeDetailsJson.setEmployeeId(employee.getEmployeeId());
//        employeeDetailsJson.setRegNo(employee.getEmployeeRegistrationNo());
//
//        if (null != employee.getPassportNo() && !(employee.getPassportNo().equals(""))) {
//            employeeDetailsJson.setIdType("Passport");
//            employeeDetailsJson.setPassportNo(employee.getPassportNo());
//        }
//        if (null != employee.getDrivingLicenceNo() && !(employee.getDrivingLicenceNo().equals(""))) {
//            employeeDetailsJson.setIdType("Driving Licence");
//            employeeDetailsJson.setDrivingLicenceNo(employee.getDrivingLicenceNo());
//        }
//        if (null != employee.getNicNo() && !(employee.getNicNo().equals(""))) {
//            employeeDetailsJson.setIdType("NRIC");
//            employeeDetailsJson.setNicNo(employee.getNicNo());
//        }
//
//        employeeDetailsJson.setDateJoined(DateUtil.dateToString(employee.getDateJoined(), Formats.DEFAULTDATE));
//        employeeDetailsJson.setFirstName(employee.getFirstName());
//        if (null != employee.getMiddleName() && !(employee.getMiddleName().equals(""))) {
//            employeeDetailsJson.setMiddleName(employee.getMiddleName());
//        }
//        employeeDetailsJson.setLastName(employee.getLastName());
//        employeeDetailsJson.setGender(employee.getGender());
//        employeeDetailsJson.setMaritalStatus(employee.getMaritalStatus());
//        employeeDetailsJson.setNoOfChildren(employee.getNoOfChildren());
//        employeeDetailsJson.setDateOfBirth(DateUtil.dateToString(employee.getDateOfBirth(), Formats.DEFAULTDATE));
//        employeeDetailsJson.setBloodGroup(employee.getBloodGroupId());
//        if (null != employee.getMiddleName() && !(employee.getBirthPlace().equals(""))) {
//            employeeDetailsJson.setBirthPlace(employee.getBirthPlace());
//        } else {
//            employeeDetailsJson.setBirthPlace("N/A");
//        }
//        employeeDetailsJson.setNationality(employee.getNationalityId().getNationalityId());
//
//        List<EmployeeLanguageLink> languageLinks = languageLinkService.findByEmployeeId(employee.getEmployeeId());
//
//        List<String> languages = new ArrayList<String>();
//
//        for (EmployeeLanguageLink languageLink : languageLinks) {
//            languages.add(languageLink.getLanguageId().getLanguageId());
//        }
//
//        if (!(languages.isEmpty())) {
//            employeeDetailsJson.setLanguage1(languages.get(0));
//            employeeDetailsJson.setLanguage2(languages.get(1));
//        } else {
//            employeeDetailsJson.setLanguage1("N/A");
//            employeeDetailsJson.setLanguage2("N/A");
//        }
//
//        employeeDetailsJson.setReligion(employee.getReligionId().getReligionId());
//        employeeDetailsJson.setDepartment(employee.getDepartmentId().getDepartmentId());
//        employeeDetailsJson.setEmployeeCategory(employee.getEmployeeCategoryId().getEmployeeCategoryId());
//        try {
//            employeeDetailsJson.setContractEndDate(DateUtil.dateToString(employee.getContractEndDate(), Formats.DEFAULTDATE));
//        } catch (Exception e) {
//            employeeDetailsJson.setContractEndDate("");
//        }
//        employeeDetailsJson.setJobTitle(employee.getJobTitle().getJobTitle());
//        employeeDetailsJson.setSalutation(employee.getSalutaionId());
//        employeeDetailsJson.setStatus(employee.getStatus());
//
//        if (!StringUtils.isEmpty(employee.getImageId())) {
//            employeeDetailsJson.setImageLoc(servletContext.getContextPath() + "/employee-image?file=" + employee.getImageId().getImagePath());
//            employeeDetailsJson.setImageId(employee.getImageId().getImagePath());
//        }
//        //set employee address list
//        List<EmployeeAddress> addresses = employeeAddressService.findByEmployee(employee.getEmployeeId());
//
//        for (EmployeeAddress employeeAddress : addresses) {
//            if (employeeAddress.getAddressType1().getAddressType().equalsIgnoreCase("Personal")) {
//                employeeDetailsJson.setPersonalCity(employeeAddress.getCity().getCityPK().getCityId());
//                employeeDetailsJson.setPersonalCountry(employeeAddress.getCity().getCityPK().getCountryId());
//                employeeDetailsJson.setPersonalProvince(employeeAddress.getCity().getCityPK().getProvinceId());
//                employeeDetailsJson.setPersonalStreetAddress1(employeeAddress.getStreetAddress1());
//                employeeDetailsJson.setPersonalStreetAddress2(employeeAddress.getStreetAddress2());
//            } else if (employeeAddress.getAddressType1().getAddressType().equalsIgnoreCase("Postal")) {
//                employeeDetailsJson.setPostalCity(employeeAddress.getCity().getCityPK().getCityId());
//                employeeDetailsJson.setPostalCountry(employeeAddress.getCity().getCityPK().getCountryId());
//                employeeDetailsJson.setPostalProvince(employeeAddress.getCity().getCityPK().getProvinceId());
//                employeeDetailsJson.setPostalStreetAddress1(employeeAddress.getStreetAddress1());
//                employeeDetailsJson.setPostalStreetAddress2(employeeAddress.getStreetAddress2());
//            }
//        }
//
//        // contact
//        List<EmployeeContact> contacts = employeeContactService.findByEmployee(employee.getEmployeeId());
//
//        for (EmployeeContact employeeContact : contacts) {
//            if (employeeContact.getEmployeeContactPK().getContactCategory().equalsIgnoreCase("primary") && employeeContact.getEmployeeContactPK().getContactType().equalsIgnoreCase("telephone")) {
//                employeeDetailsJson.setPhoneNumberOne(employeeContact.getContact());
//            }
//
//            if (employeeContact.getEmployeeContactPK().getContactCategory().equalsIgnoreCase("primary") && employeeContact.getEmployeeContactPK().getContactType().equalsIgnoreCase("land line")) {
//                employeeDetailsJson.setPhoneNumberTwo(employeeContact.getContact());
//            }
//
//            if (employeeContact.getEmployeeContactPK().getContactCategory().equalsIgnoreCase("primary") && employeeContact.getEmployeeContactPK().getContactType().equalsIgnoreCase("email")) {
//                employeeDetailsJson.setPersonalEmail(employeeContact.getContact());
//            }
//
//            if (employeeContact.getEmployeeContactPK().getContactCategory().equalsIgnoreCase("normal") && employeeContact.getEmployeeContactPK().getContactType().equalsIgnoreCase("telephone")) {
//                employeeDetailsJson.setPhoneNumberTwo(employeeContact.getContact());
//            }
//
//            if (employeeContact.getEmployeeContactPK().getContactCategory().equalsIgnoreCase("normal") && employeeContact.getEmployeeContactPK().getContactType().equalsIgnoreCase("email")) {
//                employeeDetailsJson.setEmail(employeeContact.getContact());
//            }
//
//            if (employeeContact.getEmployeeContactPK().getContactCategory().equalsIgnoreCase("normal") && employeeContact.getEmployeeContactPK().getContactType().equalsIgnoreCase("fax")) {
//                employeeDetailsJson.setFax(employeeContact.getContact());
//            }
//        }
//        //sets EmployeeAreaOfExpertiseActivity
//        employeeDetailsJson.setEmployeeAreaOfExpertiseActivityJsonList(getEmployeeAreaOfExpertiseActivity(employee));
//
//        //sets EmployeeEducationQualification
//        employeeDetailsJson.setEmployeeEducationQualificationList(getEmployeeEducationQualification(employee));
//
//        //sets EmployeeTrainingJsonList
//        employeeDetailsJson.setEmployeeTrainingJsonList(getEmployeeTraining(employee));
//
//        //sets ReportToEmployeeList
//        employeeDetailsJson.setReportToEmployeeList(getReportToEmployeeDetail(employee));
//
//        //sets ReportToEmployeeList
//        employeeDetailsJson.setEmployeeHistoryList(getEmployeeExperience(employee));
//
//        return employeeDetailsJson;
//    }
//
//    public List<EmployeeAreaOfExpertiseActivityJson> getEmployeeAreaOfExpertiseActivity(Employee employee) {
//
//        List<EmployeeAreaOfExpertiseActivityJson> employeeAreaOfExpertiseActivity = new ArrayList<>();
//        for (EmployeeAreaOfExpertiseActivityLink empAreaOfExpertiseActivity : employeeAreaOfExpertiseActivityLinkService.findByEmployeeId(employee.getEmployeeId())) {
//            EmployeeAreaOfExpertiseActivityJson areaOfExpertiseActivity = new EmployeeAreaOfExpertiseActivityJson();
//            areaOfExpertiseActivity.setAreaOfExpertise(empAreaOfExpertiseActivity.getAreaOfExpertise1().getAreaOfExpertise());
//            areaOfExpertiseActivity.setAreaOfExpertiseActivity(empAreaOfExpertiseActivity.getAreaOfExpertiseActivity1().getAreaOfExpertiseActivity());
//            areaOfExpertiseActivity.setStatus(empAreaOfExpertiseActivity.getStatus());
//            employeeAreaOfExpertiseActivity.add(areaOfExpertiseActivity);
//        }
//        return employeeAreaOfExpertiseActivity;
//
//    }
//
//    public List<EmployeeEducationQualificationJson> getEmployeeEducationQualification(Employee employee) {
//
//        List<EmployeeEducationQualificationJson> employeeEducationQualification = new ArrayList<>();
//        for (EmployeeQualificationLink employeeQualificationLink : employeeEducationService.findByEmployee(employee.getEmployeeId())) {
//            EmployeeEducationQualificationJson employeeEducationQualificationJson = new EmployeeEducationQualificationJson();
//            employeeEducationQualificationJson.setFieldOfStudy(employeeQualificationLink.getEmployeeQualificationLinkPK().getFieldOfStudy());
//            employeeEducationQualificationJson.setInstitute(employeeQualificationLink.getInstitute().getInstituteId());
//            employeeEducationQualificationJson.setInstituteName(instituteService.findByInstituteId(employeeQualificationLink.getInstitute().getInstituteId()).getName());
//            employeeEducationQualificationJson.setQualificationType(employeeQualificationLink.getEducationQualificationType().getQualificationTypeId());
//            employeeEducationQualificationJson.setYear(employeeQualificationLink.getYear());
//            employeeEducationQualificationJson.setQualification(employeeQualificationLink.getEmployeeQualificationLinkPK().getQualification());
//            employeeEducationQualificationJson.setStatus(employeeQualificationLink.getStatus());
//            employeeEducationQualification.add(employeeEducationQualificationJson);
//        }
//        return employeeEducationQualification;
//
//    }
//
//    public List<EmployeeTrainingJson> getEmployeeTraining(Employee employee) {
//
//        List<EmployeeTrainingJson> employeeTraining = new ArrayList<>();
//        for (EmployeeTraining employeeTrainingObj : employeeTrainingService.findByEmployeeId(employee.getEmployeeId())) {
//            EmployeeTrainingJson employeeTrainingJson = new EmployeeTrainingJson();
//            employeeTrainingJson.setAreaOfExpertise(employeeTrainingObj.getEmployeeTrainingPK().getAreaOfExpertise());
//            employeeTrainingJson.setCountryCode(employeeTrainingObj.getCountryCode());
//            employeeTrainingJson.setFromDate(DateUtil.dateToString(employeeTrainingObj.getEmployeeTrainingPK().getFromDate(), Formats.DEFAULTDATE));
//            employeeTrainingJson.setToDate(DateUtil.dateToString(employeeTrainingObj.getToDate(), Formats.DEFAULTDATE));
//            employeeTrainingJson.setInstitute(employeeTrainingObj.getInstitute().getInstituteId());
//            employeeTrainingJson.setInstituteName(instituteService.findByInstituteId(employeeTrainingObj.getInstitute().getInstituteId()).getName());
//            employeeTrainingJson.setStatus(employeeTrainingObj.getStatus());
//            employeeTraining.add(employeeTrainingJson);
//        }
//        return employeeTraining;
//
//    }
//
//    public List<ReportToEmployeeDetailJson> getReportToEmployeeDetail(Employee employee) {
//
//        List<ReportToEmployeeDetailJson> reportToEmployeeDetail = new ArrayList<>();
//        List<ReportingToDetail> reportDetail = reportingToDetailService.findbyId(employee.getEmployeeId());
//
//        for (ReportingToDetail reportDetail1 : reportDetail) {
//            ReportToEmployeeDetailJson reportToEmployeeDetails = new ReportToEmployeeDetailJson();
//
//            Employee employeeDetails = employeeService.findByEmployeeId(reportDetail1.getReportingToDetailPK().getReportingToEmployeeId());
//            reportToEmployeeDetails.setEmployeeId(employeeDetails.getEmployeeId());
//            reportToEmployeeDetails.setFirstName(employeeDetails.getFirstName());
//            reportToEmployeeDetails.setMiddleName(employeeDetails.getMiddleName());
//            reportToEmployeeDetails.setLastName(employeeDetails.getLastName());
//            reportToEmployeeDetails.setSalutation(employeeDetails.getSalutaionId());
//            reportToEmployeeDetails.setJobTitle(employeeDetails.getJobTitle().getJobTitle());
//            reportToEmployeeDetails.setEmployeeCategory(employeeDetails.getEmployeeCategoryId().getEmployeeCategoryId());
//            reportToEmployeeDetails.setDepartment(employeeDetails.getDepartmentId().getDepartmentId());
//            reportToEmployeeDetails.setStatus(employeeDetails.getStatus());
//            reportToEmployeeDetail.add(reportToEmployeeDetails);
//        }
//        return reportToEmployeeDetail;
//    }
//
//    public List<EmployeeHistoryJson> getEmployeeExperience(Employee employee) {
//
//        List<EmployeeHistoryJson> employeeHistory = new ArrayList<>();
//        for (EmployeeHistory employeeHistoryObj : employeeHistoryService.findByEmployeeId(employee.getEmployeeId())) {
//            EmployeeHistoryJson employeeHistoryJson = new EmployeeHistoryJson();
//            employeeHistoryJson.setDateJoined(DateUtil.dateToString(employeeHistoryObj.getEmployeeHistoryPK().getDateJoined(), Formats.DEFAULTDATE));
//            employeeHistoryJson.setDateLeft(DateUtil.dateToString(employeeHistoryObj.getEmployeeHistoryPK().getDateLeft(), Formats.DEFAULTDATE));
//            employeeHistoryJson.setEmployer(employeeHistoryObj.getEmployer());
//            employeeHistoryJson.setInstitute(employeeHistoryObj.getInstitute().getInstituteId());
//            employeeHistoryJson.setInstituteName(instituteService.findByInstituteId(employeeHistoryObj.getInstitute().getInstituteId()).getName());
//            employeeHistoryJson.setJobTitle(employeeHistoryObj.getJobTitle().getJobTitle());
//            employeeHistoryJson.setStatus(employeeHistoryObj.getStatus());
//            employeeHistory.add(employeeHistoryJson);
//        }
//        return employeeHistory;
//
//    }
//
//    public List<EmployeeJson> toJson(List<Employee> list) {
//
//        List<EmployeeJson> listReturn = new ArrayList<>();
//        for (Employee employeeDetail : list) {
//            new EmployeeJson();
//            listReturn.add(toJson(employeeDetail));
//        }
//        return listReturn;
//    }
//
//    @RequestMapping(value = "/update/employeestatus", method = RequestMethod.POST, headers = "Accept=application/json")
//    @ResponseBody
//    public JsonReturn updateLectureStatus(
//            @RequestParam(value = "employeeIdReport", required = true) String employeeIdReport,
//            @RequestParam(value = "employeeId", required = true) String employeeId,
//            @RequestParam(value = "status", required = false) String status,
//            @RequestParam(value = "userName", required = true) String userName) {
//
//        JsonReturn jsonReturn = new JsonReturn();
//
//        ReportingToDetail findByReportToDetailID = reportingToDetailService.findByReportToDetailID(new ReportingToDetailPK(employeeId, employeeIdReport));
//
//        try {
//            reportingToDetailService.delete(findByReportToDetailID);
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//
//        jsonReturn.setSuccess(successValue.SUCCESS);
//        jsonReturn.setResult(findByReportToDetailID.getReportingToDetailPK().getReportingToEmployeeId());
//        return jsonReturn;
//
//    }
//
//    /**
//     * generate employee contact list
//     *
//     * @param employee
//     * @param phoneNoOne
//     * @param personalEmail
//     * @param phoneNoTwo
//     * @param email
//     * @param fax
//     * @return
//     */
//    private List<Contact> getEmployeeContactList(Employee employee, String phoneNoOne, String personalEmail, String phoneNoTwo, String email, String fax) {
//        List<Contact> contactList = new ArrayList<>();
//
//        contactList.add(new Contact(employee.getEmployeeId(), "Primary", "Telephone", phoneNoOne));
//
//        contactList.add(new Contact(employee.getEmployeeId(), "Primary", "Email", personalEmail));
//
//        contactList.add(new Contact(employee.getEmployeeId(), "Normal", "Telephone", phoneNoTwo));
//
//        contactList.add(new Contact(employee.getEmployeeId(), "Normal", "Email", email));
//
//        contactList.add(new Contact(employee.getEmployeeId(), "Normal", "Fax", fax));
//
//        return contactList;
//    }
//
//}
