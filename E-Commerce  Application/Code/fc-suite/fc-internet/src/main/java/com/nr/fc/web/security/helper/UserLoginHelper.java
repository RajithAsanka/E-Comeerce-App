package com.nr.fc.web.security.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.nr.fc.model.User;
import com.nr.fc.service.user.UserService;

/**
 * This is Authentication provider class to perform the user authentication in
 * spring security.
 *
 * @author Lakshitha
 *
 */
@Component("userLoginHelper")
public class UserLoginHelper implements UserDetailsService {

    @Autowired
    private UserService userService;

    /**
     * The static logger to log
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginHelper.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang
     * .String)
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        User user;
        LoginUser ibUser = null;
        try {
            user = userService.findByUserNameANDActiveApprove(username);

            // System.out.println("USER ### "+user.getEmployeeId());
            if (user == null) {
                throw new UsernameNotFoundException(username);
            } else {
                user = userService.initSystemUser(username);
            }
            ibUser = (LoginUser) LazyBeanUtils.copyBean(LoginUser.class, user);

        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException(username);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ibUser;
    }
}
