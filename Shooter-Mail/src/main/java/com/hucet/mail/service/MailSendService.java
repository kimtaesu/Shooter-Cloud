package com.hucet.mail.service;

import com.hucet.mail.content.MailContentConstructor;
import com.hucet.mail.properties.MailConfProperties;
import com.hucet.mail.stream.dto.MailDto;
import com.hucet.mail.type.EmailType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

@Service
@Transactional
@Slf4j
public class MailSendService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    MailContentConstructor mailContentConstructor;
    @Autowired
    MailConfProperties mailConfProperties;

    @Async(value = "emailExecutor")
    public void mailSend(EmailType type, MailDto dto) {
        if (!mailConfProperties.getEnable()) {
            log.info("mail config are not enabled. ");
            return;
        }
        switch (type) {
            case EMAIL_CERT:
                try {
                    javaMailSender.send(mailContentConstructor.createMimeMessageForEmailCertification(dto));
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
