/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.service.employee;

import com.nr.fc.criteria.EmployeeCriteria;
import java.util.List;

import com.nr.fc.model.Employee;

/**
 * The Interface EmployeeService.
 *
 * @author Amith Fernando
 */
public interface EmployeeService {

    /**
     * Save.
     *
     * @param employee the employee
     * @param language1
     * @param language2
     * @param contactList the contact list
     * @param employeeAddressList the employee address list
     * @param employeeReportList
     * @param userName the user name
     * @throws Exception the exception
     */
    // public void save(Employee employee, String language1, String language2, List<Contact> contactList, List<EmployeeAddress> employeeAddressList, List<EmployeeJson> employeeReportList, String userName) throws Exception;
    /**
     * Update.
     *
     * @param employee the employee
     * @param language1
     * @param language2
     * @param contactList the contact list
     * @param employeeAddressList the employee address list
     * @param employeeReportList
     * @param userName the user name
     * @throws Exception the exception
     */
    // public void update(Employee employee, String language1, String language2, List<Contact> contactList, List<EmployeeAddress> employeeAddressList, List<EmployeeJson> employeeReportList, String userName) throws Exception;
    /**
     * Edits the.
     *
     * @param employee the employee
     * @throws Exception the exception
     */
    public void edit(Employee employee) throws Exception;

    /**
     * Delete.
     *
     * @param employee the employee
     * @throws Exception the exception
     */
    public void delete(Employee employee) throws Exception;

    /**
     * Find all.
     *
     * @return the list
     */
    public List<Employee> findAll();

    /**
     * Find like employee id.
     *
     * @param employeeId the employee id
     * @return the list
     */
    public List<Employee> findLikeEmployeeId(String employeeId);

    /**
     * Find by criteria.
     *
     * @param employeeCriteria
     * @return the list
     */
    public List<Employee> findByCriteria(EmployeeCriteria employeeCriteria);

    /**
     * Find like employee id and name.
     *
     * @param employeeId the employee id
     * @param name the name
     * @return the list
     */
    public List<Employee> findLikeEmployeeIdAndName(String employeeId, String name);

    /**
     * Find like name.
     *
     * @param name the name
     * @return the list
     */
    public List<Employee> findLikeName(String name);

    /**
     * Generate employee id.
     *
     * @return the string
     */
    public String generateEmployeeId();

    /**
     * Find by employee id.
     *
     * @param employeeId the employee id
     * @return the employee
     */
    public Employee findByEmployeeId(String employeeId);

    /**
     *
     * @return
     */
    public List<Employee> findAllActiveEmployees();

    /**
     *
     * @param departmentId
     * @return
     */
    public List<Employee> findByDepartment(String departmentId);

    /**
     *
     * @param employeeRegId
     * @return
     */
    public Employee findByRegistrationId(String employeeRegId);

    /**
     *
     * @param employeeRegId
     * @return
     */
    public Employee checkLoginUserIsATeacher(String employeeRegId);


}
