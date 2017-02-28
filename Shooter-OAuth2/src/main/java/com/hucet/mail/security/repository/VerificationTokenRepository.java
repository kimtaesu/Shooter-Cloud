package com.hucet.mail.security.repository;

import com.hucet.mail.security.domain.Account;
import com.hucet.mail.security.domain.VerificationToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

/**
 * Created by taesu on 2017-02-28.
 */
public interface VerificationTokenRepository extends Repository<VerificationToken, Long> {
    VerificationToken save(VerificationToken token);

    Optional<VerificationToken> findByToken(String token);

    Optional<VerificationToken> findByAccount(Account account);

    @Modifying
    @Query("update VerificationToken v set v.expiryDate = :expiry_date, v.token = :token where v.account = :account")
    void setVerificationToken(@Param("expiry_date") Date expiry_date, @Param("token") String token, @Param("account") Account account);
}
