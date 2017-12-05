
package com.nr.fc.web.security.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * The Class SecurityContextAccessor.
 *
 * @author Mohamed Sayyaff
 */
public class SecurityContextAccessor {

	/** The authentication trust resolver. */
	@Autowired
	private AuthenticationTrustResolver authenticationTrustResolver;
	
	/**
	 * Checks if is current authentication anonymous.
	 *
	 * @return true, if is current authentication anonymous
	 */
	public boolean isCurrentAuthenticationAnonymous(){
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}	
}
