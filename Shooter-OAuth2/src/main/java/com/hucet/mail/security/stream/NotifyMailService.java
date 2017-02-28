package com.hucet.mail.security.stream;

import com.hucet.mail.security.stream.processor.CertMailProcessor;
import com.hucet.shared.MailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding(CertMailProcessor.class)
public class NotifyMailService {
    @Autowired
    CertMailProcessor certMailProcessor;

    public void notifyCertMail(MailDto dto) {
        certMailProcessor.output().send(
                MessageBuilder
                        .withPayload(dto)
                        .build()
        );
    }
}
