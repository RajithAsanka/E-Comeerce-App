
package com.nr.fc.web.security.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.nr.fc.enums.GeneralStatus;
import com.nr.fc.model.User;
import com.nr.fc.service.user.UserService;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        // super.onAuthenticationFailure(request, response, exception);
        try {
            if (exception.getClass().isAssignableFrom(BadCredentialsException.class)) {

                UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) exception.getAuthentication();

                WebAuthenticationDetails details = (WebAuthenticationDetails) token.getDetails();

                String usrname = token.getName();

                // TODO user suspend message display
                User user = null;

                user = userService.findByUserName(usrname);

                if (user == null) {
                    response.sendRedirect("login?error=invalidUser");
                } else {
                    if (user.getStatus().equals(GeneralStatus.DEACTIVE)) {
                        response.sendRedirect("login?error=userNotActive");
                    } else {
//                        int attempts = user.getLoginAttempts();
//                        attempts++;
//                        if (attempts == 3) {
//                            user.setStatus(GeneralStatus.DEACTIVE);
//                        }
//                        user.setLoginAttempts(attempts);
                        userService.update(user);
                        // USER SUSPEND IF LOGIN FAILED 3 ATTMPTS
                        response.sendRedirect("login?error=badCredentials");
                    }
                }
            } else if (exception.getClass().isAssignableFrom(DisabledException.class)) {

                response.sendRedirect("login?error=badCredentials");
            } else {
                exception.printStackTrace();
                response.sendRedirect("login?error=error");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
