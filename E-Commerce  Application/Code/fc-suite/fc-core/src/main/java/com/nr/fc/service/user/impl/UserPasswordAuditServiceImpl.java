/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.service.user.impl;

import com.nr.fc.dao.UserPasswordAuditDao;
import com.nr.fc.model.Role;
import com.nr.fc.model.UserPasswordAudit;
import com.nr.fc.service.user.UserPasswordAuditService;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Madhuranga Samarasinghe
 */
@Service
public class UserPasswordAuditServiceImpl implements UserPasswordAuditService {

    @Autowired
    private UserPasswordAuditDao userPasswordAuditDao;

    @Override
    public List<UserPasswordAudit> findByPassword(String hashedPassword) {
        List<UserPasswordAudit> passwordAudits = new ArrayList<>();
        try {
            String sql = "SELECT a FROM UserPasswordAudit a WHERE ";
            sql += " a.password =:password ORDER BY a.id DESC";
            Map<String, Object> params = new HashMap<>();
            params.put("password", hashedPassword);
            return userPasswordAuditDao.findbyQueryLimit(sql, params, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passwordAudits;
    }

    @Override
    public void save(UserPasswordAudit userPasswordAudit) {
        userPasswordAudit.setId(getLastGeneratedId());
        userPasswordAuditDao.create(userPasswordAudit);
    }

    private String getLastGeneratedId() {
        //after the bug 
        // String sql = "SELECT a FROM TimetableModuleLink a ORDER BY a.timetableModuleId DESC ";
        String sql = "SELECT  CONVERT(SUBSTRING(id, 3),UNSIGNED INTEGER) as temp FROM fsms_user_password_audit a ORDER BY temp DESC";

        List<BigInteger> list = userPasswordAuditDao.findNativeQueryIntegerList(sql, new HashMap<String, Object>());

        String prefix = "UP";
        String firstid = "001";

        if (!list.isEmpty()) {

            int lastIdVal = 0;

            try {

                for (BigInteger list1 : list) {
                    lastIdVal = ((BigInteger) list1).intValue();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            int newidNumber = (lastIdVal + 1);
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);

            String lastId = prefix + numberFormat.format(newidNumber);
            return lastId;
        } else {
            return prefix + firstid;
        }

    }
}
