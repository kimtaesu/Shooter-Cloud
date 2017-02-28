package com.hucet.mail.security.event;

import com.hucet.mail.security.domain.Account;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class OnAccountRegistered extends ApplicationEvent {
    private String appUrl;
    private Account account;

    public OnAccountRegistered(Object source, Account account, String appUrl) {
        super(source);
        this.appUrl = appUrl;
        this.account = account;
    }
}
