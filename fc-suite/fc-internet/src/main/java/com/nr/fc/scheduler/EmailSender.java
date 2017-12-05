
package com.nr.fc.scheduler;


import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Amith
 */
public class EmailSender {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(EmailSender.class);

//    @Autowired
//    private EmailService emailService;
//    @Autowired
//    private EmailSendingService emailSendingService;

    public void sendEmails() {
//        List<Email> emails = emailService.findByStatus(EmailStatus.PENDING);
//
//        for (Email email : emails) {
//            try {
//                emailSendingService.sendEmail(email.getToEmail(), email.getSubject(), email.getBody());
//                email.setModifiedDate(new Date());
//                email.setStatus(EmailStatus.SENT);
//                emailService.update(email);
//            } catch (Exception e) {
//                email.setStatus(EmailStatus.ERROR);
//                logger.error("sendEmails ", e);
//                try {
//                    emailService.update(email);
//                } catch (Exception ex) {
//                    logger.error("sendEmails ", e);
//                    e.printStackTrace();
//                }
//                e.printStackTrace();
//            }
//        }

    }

}
