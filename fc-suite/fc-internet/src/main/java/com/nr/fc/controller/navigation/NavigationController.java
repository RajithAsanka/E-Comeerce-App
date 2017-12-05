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
    //Group creation
    //##################################
    @RequestMapping(value = NavigationPath.ADMIN_PREFIX + NavigationPath.CREATE_GROUP, method = RequestMethod.GET)
    public String createGroup() {
        return "create-group";
    }

    @RequestMapping(value = NavigationPath.ADMIN_PREFIX + NavigationPath.SEARCH_GROUP, method = RequestMethod.GET)
    public String searchGroup() {
        return "search-group";
    }
    //##################################
    //Member creation
    //##################################

    @RequestMapping(value = NavigationPath.ADMIN_PREFIX + NavigationPath.CREATE_MEMBER, method = RequestMethod.GET)
    public String createMember() {
        return "member-details-enrollment";
    }

    @RequestMapping(value = NavigationPath.ADMIN_PREFIX + NavigationPath.CREATE_MEMBER_MODIFY, method = RequestMethod.GET)
    public String modifyMember() {
        return "member-details-enrollment-modify";
    }
    
     //##################################
    //Member Business Details Creation
    //##################################

    @RequestMapping(value = NavigationPath.ADMIN_PREFIX + NavigationPath.CREATE_MEMBER_BUSINESS_DETAILS, method = RequestMethod.GET)
    public String createBusinessDetails() {
        return "member-business-details-enrollment";
    }
    
     //##################################
    //Member Income and Expenses Creation
    //##################################
     @RequestMapping(value = NavigationPath.ADMIN_PREFIX + NavigationPath.CREATE_MEMBER_INCOME_EXPENSES, method = RequestMethod.GET)
    public String createIncomeExpensesDetails() {
        return "member-income-and-expenses";
    }
    
     //##################################
    //Member Guarantor Profile Creation
    //##################################
     @RequestMapping(value = NavigationPath.ADMIN_PREFIX + NavigationPath.CREATE_MEMBER_GURANTOR_PROFILE, method = RequestMethod.GET)
    public String createGurantorProfileDetails() {
        return "member-gurantor-profile";
    }

}
