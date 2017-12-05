/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.dao.impl;

import com.nr.fc.criteria.EmployeeCriteria;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.nr.fc.dao.EmployeeDao;
import com.nr.fc.model.Employee;
import com.nr.fc.model.User;
import javax.persistence.criteria.Join;

/**
 *
 * @author Amith
 */
@Component
public class EmployeeDaoImpl extends DaoImpl<Employee, String> implements EmployeeDao {

    @Override
    public List<Employee> findByCriteria(EmployeeCriteria criteria) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> trailRoot = query.from(Employee.class);

        query.select(trailRoot).distinct(true).where(buildPredicateForEmployee(criteria, builder, trailRoot));
        return entityManager.createQuery(query).getResultList();
    }

    private Predicate[] buildPredicateForEmployee(EmployeeCriteria criteria, CriteriaBuilder builder, Root<Employee> trailRoot) {
        List<Predicate> predicate = new ArrayList<>();

        if (!StringUtils.isEmpty(criteria.getRegNo())) {
            Path<String> path = trailRoot.get("employeeRegistrationNo");
            Predicate predictId = builder.like(path, criteria.getRegNo() + "%");
            predicate.add(predictId);
        }

        if (!StringUtils.isEmpty(criteria.getNicNo())) {
            Path<String> path = trailRoot.get("nicNo");
            Predicate predictName = builder.like(path, criteria.getNicNo() + "%");
            predicate.add(predictName);
        }

        if (!StringUtils.isEmpty(criteria.getDepartmentId())) {
            Path<String> path = trailRoot.join("departmentId").get("departmentId");
            Predicate predictName = builder.equal(path, criteria.getDepartmentId());
            predicate.add(predictName);
        }

        if (!StringUtils.isEmpty(criteria.getFirstName()) || !StringUtils.isEmpty(criteria.getMiddleName()) || !StringUtils.isEmpty(criteria.getLastName())) {

            Path<String> path = trailRoot.get("firstName");
            Path<String> pathMiddle = trailRoot.get("middleName");
            Path<String> pathLast = trailRoot.get("lastName");

            Predicate predictName = builder.or(builder.like(path, "%" + criteria.getFirstName() + "%"), builder.like(pathMiddle, "%" + criteria.getMiddleName() + "%"), builder.like(pathLast, "%" + criteria.getLastName() + "%"));

            predicate.add(predictName);
        }

        if (!StringUtils.isEmpty(criteria.getName())) {
            Path<String> path = trailRoot.get("firstName");
            Path<String> pathMiddle = trailRoot.get("middleName");
            Path<String> pathLast = trailRoot.get("lastName");

            Predicate predictName = builder.or(builder.like(path, "%" + criteria.getName() + "%"), builder.like(pathMiddle, "%" + criteria.getName() + "%"), builder.like(pathLast, "%" + criteria.getName() + "%"));

            predicate.add(predictName);
        }

        if (!StringUtils.isEmpty(criteria.getCategory())) {
            Path<String> path = trailRoot.join("employeeCategoryId").get("employeeCategoryId");
            Predicate predictName = builder.equal(path, criteria.getCategory());
            predicate.add(predictName);
        }

        if (!StringUtils.isEmpty(criteria.getDob())) {
            Path<String> path = trailRoot.get("dateOfBirth");
            Predicate predictName = builder.equal(path, criteria.getDob());
            predicate.add(predictName);
        }

        if (!StringUtils.isEmpty(criteria.getJoiningDate())) {
            Path<String> path = trailRoot.get("dateJoined");
            Predicate predictName = builder.equal(path, criteria.getJoiningDate());
            predicate.add(predictName);
        }

        if (!StringUtils.isEmpty(criteria.getDrivingLNo())) {
            Path<String> path = trailRoot.get("drivingLicenceNo");
            Predicate predictName = builder.like(path, criteria.getDrivingLNo() + "%");
            predicate.add(predictName);
        }

        if (!StringUtils.isEmpty(criteria.getNricNo())) {
            Path<String> path = trailRoot.get("nicNo");
            Predicate predictName = builder.like(path, criteria.getNricNo() + "%");
            predicate.add(predictName);
        }

        if (!StringUtils.isEmpty(criteria.getBirthPlace())) {
            Path<String> path = trailRoot.get("birthPlace");
            Predicate predictName = builder.equal(path, criteria.getBirthPlace());
            predicate.add(predictName);
        }

        if (!StringUtils.isEmpty(criteria.getPassportNo())) {
            Path<String> path = trailRoot.get("passportNo");
            Predicate predictName = builder.like(path, criteria.getPassportNo() + "%");
            predicate.add(predictName);
        }

        if (!StringUtils.isEmpty(criteria.getApproveMode())) {
            Join<Employee, User> user = trailRoot.join("userList");
            Path<String> path = user.get("approveMode");
            Predicate pEqEnabled = builder.equal(path, criteria.getApproveMode());
            predicate.add(pEqEnabled);

        }

        if (!StringUtils.isEmpty(criteria.getUserStatus())) {
            Join<Employee, User> user = trailRoot.join("userList");
            Path<String> path = user.get("status");
            Predicate pEqEnabled = builder.equal(path, criteria.getUserStatus());
            predicate.add(pEqEnabled);

        }

        return predicate.toArray(new Predicate[predicate.size()]);
    }

}
