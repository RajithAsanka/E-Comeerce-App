
package com.nr.fc.web.security.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


/**
 * @author Danushka
 * 
 */
public class CustomLogoutSuccessHandler extends DefaultRedirectStrategy implements LogoutSuccessHandler {
  
  @Override
  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {
  
    // get redirect URL.
    String targetUrl = determineTargetUrl(authentication);

    
    SecurityContextHolder.clearContext();
    request.getSession().invalidate();
    sendRedirect(request, response, targetUrl);
    
   // String refererUrl = request.getHeader("Referer");
   // auditService.track("Logout from: " + refererUrl);

   // super.onLogoutSuccess(request, response, authentication);
    
  }
  
  /*
   * Builds the target URL that user need to redirect after success login according to the
   * authentication.
   */
  protected String determineTargetUrl(Authentication authentication) {
  
    return "/login";
  }
  
}
