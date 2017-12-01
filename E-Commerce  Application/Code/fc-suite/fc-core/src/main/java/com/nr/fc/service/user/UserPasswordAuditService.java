/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.service.user;

import com.nr.fc.model.UserPasswordAudit;
import java.util.List;

/**
 *
 * @author Madhuranga Samarasinghe
 */
  public interface UserPasswordAuditService {

    public List<UserPasswordAudit> findByPassword(String hashedPassword);

    public void save(UserPasswordAudit userPasswordAudit);
    
}
