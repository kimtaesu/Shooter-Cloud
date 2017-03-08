package com.hucet.security.service;


import com.hucet.security.domain.Account;
import com.hucet.security.domain.VerificationToken;
import com.hucet.security.exception.NotRegisteredException;
import com.hucet.security.utils.Utils;
import com.hucet.security.repository.VerificationTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class VerificationTokenService {
    @Autowired
    VerificationTokenRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public VerificationToken createVerificationToken(Account account, String token) {
        Optional<VerificationToken> vToken = repository.findByAccount(account);
        if (vToken.isPresent()) {
            repository.setVerificationToken(Utils.calculateExpiryDate(),
                    token,
                    account);
            entityManager.refresh(vToken.get());
            return vToken.get();
        } else {
            VerificationToken verificationToken = new VerificationToken(account, token);
            return repository.save(verificationToken);
        }
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
        throw new NotRegisteredException("등록된 사용자가 없습니다.");
    }
}
