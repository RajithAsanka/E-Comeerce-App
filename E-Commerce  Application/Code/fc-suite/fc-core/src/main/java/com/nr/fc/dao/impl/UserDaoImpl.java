
package com.nr.fc.dao.impl;

import org.springframework.stereotype.Repository;

import com.nr.fc.dao.UserDao;
import com.nr.fc.model.User;

/**
 *
 * @author Amith
 */
@Repository
public class UserDaoImpl extends DaoImpl<User,String> implements UserDao {
    
}
