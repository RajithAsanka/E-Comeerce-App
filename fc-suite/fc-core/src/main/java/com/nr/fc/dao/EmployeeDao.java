/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.dao;

import com.nr.fc.criteria.EmployeeCriteria;
import java.util.List;

import com.nr.fc.model.Employee;

/**
 *
 * @author Amith
 */
public interface EmployeeDao extends IDao<Employee, String> {

    public List<Employee> findByCriteria(EmployeeCriteria criteria);
}
