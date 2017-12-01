
package com.nr.fc.service.user;

import java.util.List;

import com.nr.fc.model.Privilege;

// TODO: Auto-generated Javadoc
/**
 * The Interface PrivilegeService.
 *
 * @author Amith
 */
public interface PrivilegeService {

    /**
     * Find all.
     *
     * @return the list
     */
    public List<Privilege> findAll();

    /**
     * Find by status.
     *
     * @param status the status
     * @return the list
     */
    public List<Privilege> findByStatus(String status);
    
    /**
     * Find by id.
     *
     * @param id the id
     * @return the privilege
     */
    public Privilege findById(String id);
    
    /**
     * Save.
     *
     * @param privilege the privilege
     */
    public void save(Privilege privilege);
    
    /**
     * Update.
     *
     * @param privilege the privilege
     */
    public void update(Privilege privilege);
}
