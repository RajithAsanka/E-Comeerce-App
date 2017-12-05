/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.email;

import com.nr.fc.enums.UserTypes;
import com.nr.fc.model.Employee;
import com.nr.fc.model.User;
import com.nr.fc.properties.EmailProperty;
import com.nr.fc.service.employee.EmployeeService;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Madhuranga Samarasinghe
 */
@Component
public class UserApproveEmail {

    @Autowired
    private EmployeeService employeeService;

    public String sendApproveEmail(User user, String password, String bodyType) {
        String result = null;
        try {
            EmailProperty emailProperty = new EmailProperty();

            String email = null;
            StringBuilder name = new StringBuilder();

            if (user.getUserType().equals(UserTypes.EMPLOYEE)) {
                name.append(user.getEmployeeId().getSalutaionId());
                name.append(" ");
                name.append(user.getEmployeeId().getFirstName());
                name.append(" ");
                name.append(user.getEmployeeId().getLastName());

                Employee employeeObj = employeeService.findByEmployeeId(user.getEmployeeId().getEmployeeId());

                if (null != employeeObj) {
                    email = employeeObj.getEmail();
                }

            }

            emailProperty.setToAddresses(email);

            if (bodyType.equalsIgnoreCase("firsttimelogin")) {
                emailProperty.setBody(generateEmailBody(name.toString(), password, user.getUserName()));
            } else if (bodyType.equalsIgnoreCase("forgetpassword")) {
                emailProperty.setBody(generateEmailBodyForForgetPassword(name.toString(), password, user.getUserName()));
            } else if (bodyType.equalsIgnoreCase("passwordreset")) {
                emailProperty.setBody(generateEmailBodyForForgetPassword(name.toString(), password, user.getUserName()));
            }

            SendHTMLEmail sendHTMLEmail = new SendHTMLEmail();
            result = sendHTMLEmail.sendEmail(emailProperty);

        } catch (Exception e) {
        }
        return result;
    }

    private String generateEmailBody(String name, String password, String username) throws IOException {
        StringBuilder emailBody = new StringBuilder();

        Properties props = new Properties();
        InputStream input = getClass().getClassLoader().getResourceAsStream("email_config.properties");
        props.load(input);

        emailBody.append("<p>Dear " + name);
        emailBody.append("</p>");
        emailBody.append("<p>Here is the link to log in to The First Credit Loan Management System:</p>");
        emailBody.append("<a href=" + props.getProperty("loginUrl") + ">" + props.getProperty("loginUrl") + "</a>");
        emailBody.append("</p>");
        emailBody.append("<p>Please use following log in credentials for your first time log in.</p>");
        emailBody.append("<p>Username : " + username);
        emailBody.append("</p>");
        emailBody.append("<p>Password :" + password);
        emailBody.append("</p>");
        emailBody.append("</p>This is the auto generated message and please do not reply.</p>");
        emailBody.append("</p>");
        emailBody.append("<p>Thank you.</p>");
        return emailBody.toString();
    }

    private String generateEmailBodyForForgetPassword(String name, String password, String username) {
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("<p>Dear " + name);
        emailBody.append("</p>");
        emailBody.append("<p>Please use following log in credentials for your password reset request.</p>");
        emailBody.append("<p>Username : " + username);
        emailBody.append("</p>");
        emailBody.append("<p>Password :" + password);
        emailBody.append("</p>");
        emailBody.append("<p>Thank you.</p>");
        return emailBody.toString();
    }

}
