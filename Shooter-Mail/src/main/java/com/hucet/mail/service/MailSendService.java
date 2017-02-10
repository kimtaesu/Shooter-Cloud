package com.hucet.mail.service;

import com.hucet.mail.MailContentConstructor;
import com.hucet.mail.type.EmailType;
import com.hucet.rabbitmq.dto.MailCertDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

/**
 * Created by taesu on 2017-01-26.
 */
public interface MailSendService {
    @Async(value = "emailExecutor")
    void mailSend(EmailType type, MailCertDto dto);

    @Service
    @Transactional
    @Slf4j
    class Impl implements MailSendService {

        @Autowired
        JavaMailSender javaMailSender;

        @Autowired
        MailContentConstructor mailContentConstructor;

        @Override
        public void mailSend(EmailType type, MailCertDto dto) {
            switch (type) {
                case EMAIL_CERT:
                    log.info("sent mail : {}", dto.getUserEmail(), dto.getUserName());
                    try {
                        javaMailSender.send(mailContentConstructor.createMimeMessageForEmailCertification(dto));
                    } catch (MessagingException e) {
                        e.printStackTrace();
                        // TODO
                    }
                    break;
            }
        }
    }
}
