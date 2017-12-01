
package com.nr.fc.web.security.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.nr.fc.controller.navigation.NavigationPath;
import com.nr.fc.enums.GeneralStatus;
import com.nr.fc.model.User;
import com.nr.fc.service.user.UserService;
import java.util.Date;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class handles consecutive process of login.
 *
 * @author Ruckman Colins S.
 *
 */
public class CustomAuthenticationSuccessHandler extends DefaultRedirectStrategy implements
        AuthenticationSuccessHandler {

    private Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Autowired
    private UserService userService;
    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler #
     * onAuthenticationSuccess(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
     */

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        User user = (User) authentication.getPrincipal();

        if (user.getStatus().equals(GeneralStatus.DEACTIVE)) {
            response.sendRedirect("login?error=userNotActive");
        } else {
            // Set user session
            request.getSession().setAttribute("LOGGEDIN_USER", user);
            try {
                
                User u = userService.findByUserName(user.getUserName());
                u.setLastLoginTime(new Date());
                
                
                userService.update(u);
                request.getSession().setAttribute("GREETING_MESSAGE", "true");
                
                LOGGER.info(u.getUserName() + " USER LOGIN SUCCESS ");
            } catch (ConstraintViolationException e) {
                LOGGER.error("ERROR onAuthenticationSuccess", e);
                for (ConstraintViolation<?> obj : e.getConstraintViolations()) {
                    System.out.println(obj.getRootBeanClass().getName());
                    System.out.println(obj.getPropertyPath());
                    System.out.println(obj.getInvalidValue());
                    System.out.println(obj.getConstraintDescriptor());
                    System.out.println(obj.getMessage());
                }
            } catch (Exception e) {
                LOGGER.error("ERROR onAuthenticationSuccess", e);
                response.sendRedirect("login?error=error");

            }

            sendRedirect(request, response, determineRedirectUrl(user));
        }

    }

    protected String determineRedirectUrl(User user) {

        if (user.getFirstTimeLogin()) {
            return NavigationPath.ADMIN_PREFIX + NavigationPath.FirstTimeLogin;
        } else {
            return NavigationPath.ADMIN_PREFIX + NavigationPath.DASHBOARD;
        }

    }
}
