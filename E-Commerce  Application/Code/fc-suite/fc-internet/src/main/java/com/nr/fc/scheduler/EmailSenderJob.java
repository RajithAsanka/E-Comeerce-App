
package com.nr.fc.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *
 * @author Amith
 */
public class EmailSenderJob extends QuartzJobBean {
    
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(EmailSenderJob.class);

    private EmailSender emailSender;

    public EmailSender getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

   

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Email Sender is runing");
        try {
            emailSender.sendEmails();
        } catch (Exception e) {
            logger.error("executeInternal", e);
            e.printStackTrace();
        }
        System.out.println("Email Sender is stoping");
    }
    
}
