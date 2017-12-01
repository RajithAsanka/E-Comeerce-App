
package com.nr.fc.web.security.helper;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nr.fc.model.Privilege;
import com.nr.fc.model.User;

/**
 *
 * @author Amith
 */
public class LoginUser extends User implements UserDetails {

    /**
     * Generated serial Id
     */
    private static final long serialVersionUID = -8220404920867525129L;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("000"));//default secure access
//        for (Privilege privilege : super.getPrivileges()) {
//            authorities.add(new SimpleGrantedAuthority(privilege.getPrivilegeCode()));
//        }
        return authorities;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
     */
    @Override
    public boolean isAccountNonExpired() {

        return Boolean.TRUE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
     */
    @Override
    public boolean isAccountNonLocked() {

        return Boolean.TRUE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
     */
    @Override
    public boolean isCredentialsNonExpired() {

        return Boolean.TRUE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
     */
    @Override
    public boolean isEnabled() {

        return Boolean.TRUE;
    }
    
    @Override
    public String getPassword(){
    	return (String) super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

}
