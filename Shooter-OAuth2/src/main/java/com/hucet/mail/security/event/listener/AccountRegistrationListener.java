package com.hucet.mail.security.event.listener;

import com.hucet.mail.security.domain.Account;
import com.hucet.mail.security.event.OnAccountRegistered;
import com.hucet.mail.security.service.VerificationTokenService;
import com.hucet.mail.security.stream.NotifyMailService;
import com.hucet.mail.security.stream.dto.MailDto;
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
        verificationTokenService.createVerificationToken(account, UUID.randomUUID().toString());

        log.info("The account registered event received %s", account.getUsername());
        // notify the mail queue,
        notifyMailService.notifyCertMail(new MailDto(account.getUsername(), account.getUserEmail()));
    }
}
