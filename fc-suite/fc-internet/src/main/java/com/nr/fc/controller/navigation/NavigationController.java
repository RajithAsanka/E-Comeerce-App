/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.nr.fc.controller.navigation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Rajith Asanka
 */
@Controller
public class NavigationController {

    @RequestMapping(value = NavigationPath.LOGIN, method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = NavigationPath.Forgot, method = RequestMethod.GET)
    public String showForgot() {
        return "forgot-password";
    }

    @RequestMapping(value = NavigationPath.DASHBOARD, method = RequestMethod.GET)
    public String showDashboard() {
        return "dashboard";
    }

    @RequestMapping(value = NavigationPath.ADMIN_PREFIX + NavigationPath.FirstTimeLogin, method = RequestMethod.GET)
    public String showFirstTimeLogin() {
        return "first-login";
    }

    //##################################
    //Category creation
    //##################################
    @RequestMapping(value = NavigationPath.ADMIN_PREFIX + NavigationPath.CREATE_CATEGORY, method = RequestMethod.GET)
    public String createCategory() {
        return "create-category";
    }
    
    //##################################
    //Category creation
    //##################################
    @RequestMapping(value = NavigationPath.ADMIN_PREFIX + NavigationPath.CREATE_ITEM, method = RequestMethod.GET)
    public String createItem() {
        return "create-items";
    }
}
