package com.hucet.mail.security.event;

import com.hucet.mail.security.domain.Account;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class OnAccountRegistered extends ApplicationEvent {
    private Account account;

    public OnAccountRegistered(Object source, Account account) {
        super(source);
        this.account = account;
    }
}
