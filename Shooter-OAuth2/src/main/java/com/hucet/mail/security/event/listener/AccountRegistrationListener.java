package com.hucet.mail.security.event.listener;

import com.hucet.mail.security.domain.Account;
import com.hucet.mail.security.domain.VerificationToken;
import com.hucet.mail.security.event.OnAccountRegistered;
import com.hucet.mail.security.service.VerificationTokenService;
import com.hucet.mail.security.stream.NotifyMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class AccountRegistrationListener implements ApplicationListener<OnAccountRegistered> {

    @Autowired
    NotifyMailService notifyMailService;

    @Autowired
    VerificationTokenService verificationTokenService;

    @Override
    public void onApplicationEvent(OnAccountRegistered event) {
        Account account = event.getAccount();
        VerificationToken verificationToken = verificationTokenService.createVerificationToken(account, UUID.randomUUID().toString());

        // notify the mail queue,
        notifyMailService.notifyCertMail(account, verificationToken);
    }
}
