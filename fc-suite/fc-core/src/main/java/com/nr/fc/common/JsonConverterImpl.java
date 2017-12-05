
package com.nr.fc.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.nr.fc.json.model.PrivilegeJson;
import com.nr.fc.json.model.RoleJson;
import com.nr.fc.model.Employee;
import com.nr.fc.model.Privilege;
import com.nr.fc.model.Role;

import com.nr.fc.service.user.PrivilegeService;
import com.nr.fc.service.user.RoleService;

/**
 *
 * @author Amith
 */
@Service
public class JsonConverterImpl implements JsonConverter {

//    @Autowired
//    private ClassIdService classIdService;
//    @Autowired
//    private EmployeeService employeeService;
//    @Autowired
//    private ParentGuardianService parentGuardianService;
//    @Autowired
//    private ContactCategoryService contactCategoryService;
//    @Autowired
//    private ContactTypeService contactTypeService;
    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private RoleService roleService;

    /**
     * convert class id json array to class array list
     *
     * @param jsonString
     * @return
     * @throws Exception
     */
//    @Override
//    public List<ClassId> convertClassIdList(String jsonString) throws Exception {
//        List<ClassId> arrayList = new ArrayList<>();
//        ObjectMapper mapper = new ObjectMapper();
//        List<ClassIdJson> list = mapper.readValue(jsonString, TypeFactory.defaultInstance().constructCollectionType(List.class, ClassIdJson.class));
//        for (ClassIdJson json : list) {
//            ClassId object = classIdService.findByClass(json.getClassId());
//            arrayList.add(object);
//        }
//        return arrayList;
//    }
//
//    /**
//     * convert employee json array to employee array list
//     *
//     * @param jsonString
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public List<Employee> convertEmployeeList(String jsonString) throws Exception {
//        List<Employee> arrayList = new ArrayList<>();
//        ObjectMapper mapper = new ObjectMapper();
//        List<EmployeeJson> list = mapper.readValue(jsonString, TypeFactory.defaultInstance().constructCollectionType(List.class, EmployeeJson.class));
//        for (EmployeeJson json : list) {
//            Employee object = employeeService.findByEmployeeId(json.getEmployeeId());
//            arrayList.add(object);
//        }
//        return arrayList;
//    }
//
//    /**
//     * convert ParentGuardian json array to ParentGuardian array list
//     *
//     * @param jsonString
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public List<ParentGuardian> convertParentGuardianList(String jsonString) throws Exception {
//        List<ParentGuardian> arrayList = new ArrayList<>();
//        ObjectMapper mapper = new ObjectMapper();
//        List<ParentGuradianJson> list = mapper.readValue(jsonString, TypeFactory.defaultInstance().constructCollectionType(List.class, ParentGuradianJson.class));
//        for (ParentGuradianJson json : list) {
//            ParentGuardian object = parentGuardianService.findByPK(json.getParentGuardianId());
//            arrayList.add(object);
//        }
//        return arrayList;
//    }
//
//    @Override
//    public List<OrganizationContact> convertContactList(String jsonString) throws Exception {
//      List<OrganizationContact> arrayList = new ArrayList<>();
//      ObjectMapper mapper = new ObjectMapper();
//      List<Contact> list = mapper.readValue(jsonString, TypeFactory.defaultInstance().constructCollectionType(List.class, Contact.class));
//      for (Contact json : list) {
//        /*  OrganizationContact organizationContact = new OrganizationContact();
//          organizationContact.setContact(json.getContact());
//          organizationContact.setContactCategory1(contactCategoryService.findByContactCategory(json.getContactCategory()));
//          organizationContact.setContactType1(contactTypeService.findByContactType(json.getContactType()));
//          organizationContact.setModifiedDate(new Date());
//          organizationContact.setStatus(GeneralStatus.ACTIVE);
//          organizationContact.setContactType1(contactTypeService.findByContactType(json.getContactType()));
//          organizationContact.setContactType1(contactTypeService.findByContactType(json.getContactType()));
//          arrayList.add(organizationContact);*/
//      }
//      return arrayList; 
//    }
    @Override
    public List<Privilege> convertPrivilege(String jsonString) throws Exception {
        List<Privilege> arrayList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        List<PrivilegeJson> list = mapper.readValue(jsonString, TypeFactory.defaultInstance().constructCollectionType(List.class, PrivilegeJson.class));

        //not generic
        for (PrivilegeJson json : list) {
            // if(json.isChecked()){
            Privilege object = privilegeService.findById(json.getPrivilegeName());
            arrayList.add(object);
            //  }
        }

        return arrayList;
    }



    @Override
    public List<Employee> convertEmployeeList(String jsonString)
            throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Role> convertRole(String jsonString) throws Exception {
        List<Role> arrayList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        List<RoleJson> list = mapper.readValue(jsonString, TypeFactory.defaultInstance().constructCollectionType(List.class, RoleJson.class));

        //not generic
        for (RoleJson json : list) {
            // if(json.isChecked()){
            Role object = roleService.findByRoleID(json.getRoleCode());
            arrayList.add(object);
            //  }
        }

        return arrayList;
    }

}
