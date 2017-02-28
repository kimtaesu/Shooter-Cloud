package com.hucet.mail.security.service;


import com.hucet.mail.security.domain.Account;
import com.hucet.mail.security.domain.VerificationToken;
import com.hucet.mail.security.repository.VerificationTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class VerificationTokenService {
    @Autowired
    VerificationTokenRepository repository;

    public VerificationToken createVerificationToken(Account account, String token) {
        VerificationToken verificationToken = new VerificationToken(account, token);
        return repository.save(verificationToken);
    }
}
