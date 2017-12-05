
package com.nr.fc.controller.common;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rajith Asanka
 *
 */
@Controller
public class LoginController {
  
  
  @RequestMapping(value = "/admin/dashboard", method = RequestMethod.GET)
  public ModelAndView adminPage() {
  
    ModelAndView model = new ModelAndView();
    model.addObject("title", "Spring Security Custom Login Form");
    model.addObject("message", "This is protected page!");
    model.setViewName("dashboard");
    
    return model;
    
  }
  
//  @RequestMapping(value = "/login", method = RequestMethod.GET)
//  public ModelAndView login(@RequestParam(value = "error", required = false) String error,
//      @RequestParam(value = "logout", required = false) String logout) {
//  
//    ModelAndView model = new ModelAndView();
//    if (error != null) {
//      model.addObject("error", "Please Recheck The Credentials");
//    }
//    
//    if (logout != null) {
//      model.addObject("msg", "You've been logged out successfully.");
//    }
//    model.setViewName("login");
//    
//    return model;
//    
//  }
}
