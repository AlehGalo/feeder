package com.alan.feeder.service;

import com.alan.feeder.model.config.ServerConfig;
import com.alan.feeder.model.settings.MailDefaults;
import com.alan.feeder.repository.MailRecipientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Arrays;

/**
 * Created by aleh_bahatyrou on 12/8/16.
 */
@Service("mailMessageService")
@Slf4j
public class MailMessageService implements MessageService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailDefaults mailProperties;

    @Autowired
    private MailRecipientRepository mailRecipientRepository;

    public void initConfig(ServerConfig serverConfig) {
        if (javaMailSender instanceof JavaMailSenderImpl) {
            ((JavaMailSenderImpl) javaMailSender).setHost(serverConfig.getHost());
            ((JavaMailSenderImpl) javaMailSender).setUsername(serverConfig.getUsername());
            ((JavaMailSenderImpl) javaMailSender).setPassword(serverConfig.getPassword());
        }
    }

    @Override
    public void sendMessage(Object obj) throws Exception {
        Arrays.stream(getRecipients()).forEach(a -> javaMailSender.send(sendMailMessage(String.valueOf(obj))));


    }

    private MimeMessage sendMailMessage(String text) {
        MimeMessage mimeMessage = null;
        try {
            mimeMessage = javaMailSender.createMimeMessage();
            final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(mailProperties.getDefaultFrom());
            helper.setSubject(mailProperties.getSubject());
            helper.setText(text);
            helper.setTo(getRecipients());
        }
        catch (MessagingException | javax.mail.MessagingException e) {
            log.error(e.getMessage(), e);
        }
        finally {
        }
        return mimeMessage;
    }

    private String[] getRecipients() {
        return mailRecipientRepository.findAll().stream().map(a -> a.getMailAddress()).toArray(String[]::new);
    }

}
