
package com.nr.fc.common;

import com.nr.fc.model.Employee;
import com.nr.fc.model.Privilege;
import com.nr.fc.model.Role;

import java.util.List;

/**
 *
 * @author Amith
 */
public interface JsonConverter {

    public List<Employee> convertEmployeeList(String jsonString) throws Exception;

    public List<Privilege> convertPrivilege(String jsonString) throws Exception;

    public List<Role> convertRole(String roles) throws Exception;
}
