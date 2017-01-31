package com.hucet.mail.listener;

import com.hucet.mail.dto.MailCertDtoFromMQ;
import com.hucet.mail.service.MailSendService;
import com.hucet.mail.type.EmailType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface MQListener {
    void onReceiveredMailForCert(MailCertDtoFromMQ mailUserInfoDto);

    @Service
    @Slf4j
    class MQListenerImpl implements MQListener {

        @Autowired
        MailSendService mailSendService;

        @Override
        public void onReceiveredMailForCert(MailCertDtoFromMQ mailCertDtoFromMQ) {
            log.info(mailCertDtoFromMQ.toString());
            mailSendService.mailSend(EmailType.EMAIL_CERT, mailCertDtoFromMQ);
        }
    }
}
