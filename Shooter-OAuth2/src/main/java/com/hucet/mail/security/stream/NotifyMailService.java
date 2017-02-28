package com.hucet.mail.security.stream;

import com.hucet.mail.security.domain.Account;
import com.hucet.mail.security.domain.VerificationToken;
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

    public void notifyCertMail(Account account, VerificationToken verificationToken) {

        certMailProcessor.output().send(
                MessageBuilder
                        .withPayload(new MailDto(account.getUsername(),
                                account.getUserEmail(),
                                verificationToken.getToken(),
                                verificationToken.getExpiryDate().getTime(),
                                // TODO Hypermedia url
                                "http://localhost:9999/uaa/mail/confirm"))
                        .build()
        );
    }
}
