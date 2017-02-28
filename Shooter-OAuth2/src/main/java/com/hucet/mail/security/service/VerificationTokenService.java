package com.hucet.mail.security.service;


import com.hucet.mail.security.domain.Account;
import com.hucet.mail.security.domain.VerificationToken;
import com.hucet.mail.security.repository.VerificationTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Optional;

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

    public boolean isValid(String token) {
        Calendar cal = Calendar.getInstance();
        Optional<VerificationToken> verificationToken = repository.findByToken(token);
        if (verificationToken.isPresent()) {
            if (verificationToken.get().getExpiryDate().compareTo(cal.getTime()) > 0) {
                // valid
                log.info("success to certicate from mail");
                return true;
            } else {
                log.info("fail to certicate from mail, the reason is expired");
                // expired
                return false;
            }
        }
        throw new RuntimeException("asda");
    }
}
