package com.nr.fc.controller.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nr.fc.controller.ServicePath;
import com.nr.fc.exception.DuplicateException;
import com.nr.fc.exception.EmptyException;
import com.nr.fc.json.model.JsonReturn;
import com.nr.fc.json.model.JsonReturn.successValue;
import com.nr.fc.model.Privilege;
import com.nr.fc.service.user.PrivilegeService;

@Controller
@RequestMapping(value = ServicePath.ADMIN_PREFIX + ServicePath.PRIVILEGE)
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @RequestMapping(value = "/save", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn save(@RequestParam(value = "privilegeCode", required = true) String privilegeCode,
            @RequestParam(value = "privilegeName", required = true) String privilegeName,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "status", required = true) String status) {

        Privilege privilege = new Privilege();
        JsonReturn jsonReturn = new JsonReturn();
        try {

            if (privilegeCode.isEmpty()) {
                throw new EmptyException();
            }

            if (privilegeService.findById(privilegeCode) != null) {
                throw new DuplicateException();
            }

            privilege.setDescription(description);
            privilege.setPrivilegeCode(privilegeCode);
            privilege.setPrivilegeName(privilegeName);
            privilege.setStatus(status);
            privilegeService.save(privilege);
            jsonReturn.setSuccess(successValue.SUCCESS);
            jsonReturn.setResult(privilege.getPrivilegeName());

        } catch (EmptyException e) {
            return e.getJsonReturn();
        } catch (DuplicateException e) {
            return e.getJsonReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonReturn;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<Privilege> findAll() {
        return privilegeService.findAll();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public Privilege findById(@RequestParam(value = "id", required = true) String id) {
        return privilegeService.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public JsonReturn update(@RequestParam(value = "privilegeCode", required = true) String privilegeCode,
            @RequestParam(value = "privilegeName", required = true) String privilegeName,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "status", required = true) String status) {

        Privilege privilege = privilegeService.findById(privilegeCode);
        JsonReturn jsonReturn = new JsonReturn();
        try {

            if (privilegeCode.isEmpty()) {
                throw new EmptyException();
            }

            privilege.setDescription(description);
            privilege.setPrivilegeName(privilegeName);
            privilege.setStatus(status);
            privilegeService.update(privilege);
            jsonReturn.setSuccess(successValue.SUCCESS);
            jsonReturn.setResult(privilege.getPrivilegeName());

        } catch (EmptyException e) {
            return e.getJsonReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonReturn;
    }
}
