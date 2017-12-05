package com.nr.fc.service.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nr.fc.dao.PrivilegeDao;
import com.nr.fc.model.Privilege;
import com.nr.fc.service.user.PrivilegeService;

/**
 *
 * @author Amith
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeDao privilegeDao;

    @Override
    public List<Privilege> findAll() {
        return privilegeDao.findAll();
    }

    @Override
    public List<Privilege> findByStatus(String status) {
        String sql = "SELECT a FROM Privilege WHERE a.status=:status ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", status);
        return privilegeDao.findbyQuery(sql, params);
    }

    @Override
    public Privilege findById(String id) {
        return privilegeDao.read(id);
    }

    @Transactional
    @Override
    public void save(Privilege privilege) {
        privilegeDao.create(privilege);
    }

    @Transactional
    @Override
    public void update(Privilege privilege) {
        privilegeDao.update(privilege);
    }

}
