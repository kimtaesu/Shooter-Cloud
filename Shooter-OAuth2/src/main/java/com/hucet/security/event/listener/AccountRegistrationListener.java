package com.hucet.security.event.listener;

import com.hucet.security.domain.Account;
import com.hucet.security.domain.VerificationToken;
import com.hucet.security.event.OnAccountRegistered;
import com.hucet.security.service.VerificationTokenService;
import com.hucet.security.stream.NotifyMailService;
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
