package com.hucet.mail.security.repository;

import com.hucet.mail.security.domain.VerificationToken;
import org.springframework.data.repository.Repository;

/**
 * Created by taesu on 2017-02-28.
 */
public interface VerificationTokenRepository extends Repository<VerificationToken, Long> {
    VerificationToken save(VerificationToken token);
}
