
package com.nr.fc.web.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.ThrowableAnalyzer;
import org.springframework.security.web.util.ThrowableCauseExtractor;
import org.springframework.web.filter.GenericFilterBean;

/**
 * Filter class to handle the AJAX call after session is expired. this class will send the 901 code
 * to client to indication that session got expired.
 * 
 * @author Ruckman Colins S.
 * 
 */
public class AjaxTimeoutRedirectFilter extends GenericFilterBean {
  
  /* Throwable analyzer. */
  private final ThrowableAnalyzer throwableAnalyzer = new DefaultThrowableAnalyzer();
  
  /* Auth resolver. */
  private final AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();
  
  /* custome code for session expiry.. */
  private final int customSessionExpiredErrorCode = 901;
  
  /*
   * (non-Javadoc)
   * 
   * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
   * javax.servlet.FilterChain)
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
      ServletException {
  
    try {
      chain.doFilter(request, response);
      
      logger.debug("Chain processed normally");
    } catch (IOException ex) {
      
      throw ex;
    } catch (Exception ex) {
      
      Throwable[] causeChain = throwableAnalyzer.determineCauseChain(ex);
      RuntimeException ase =
          (AuthenticationException) throwableAnalyzer
              .getFirstThrowableOfType(AuthenticationException.class, causeChain);
      
      if (ase == null) {
        ase =
            (AccessDeniedException) throwableAnalyzer.getFirstThrowableOfType(AccessDeniedException.class, causeChain);
      }
      
      if (ase != null) {
        
        if (ase instanceof AuthenticationException) {
          
          throw ase;
        } else if (ase instanceof AccessDeniedException) {
          
          if (authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {
            
            String ajaxHeader = ((HttpServletRequest) request).getHeader("X-Requested-With");
            if ("XMLHttpRequest".equals(ajaxHeader)) {
              
              HttpServletResponse resp = (HttpServletResponse) response;
              resp.sendError(this.customSessionExpiredErrorCode);
            } else {
              
              
              throw ase;
            }
          } else {
            
            throw ase;
          }
        }
      }
      
    }
  }
  
  private static final class DefaultThrowableAnalyzer extends ThrowableAnalyzer {
    
    /**
     * 
     * @see org.springframework.security.web.util.ThrowableAnalyzer#initExtractorMap()
     */
    @Override
    protected void initExtractorMap() {
    
      super.initExtractorMap();
      
      registerExtractor(ServletException.class, new ThrowableCauseExtractor() {
        @Override
        public Throwable extractCause(Throwable throwable) {
        
          ThrowableAnalyzer.verifyThrowableHierarchy(throwable, ServletException.class);
          return ((ServletException) throwable).getRootCause();
        }
      });
    }
    
  }
}
