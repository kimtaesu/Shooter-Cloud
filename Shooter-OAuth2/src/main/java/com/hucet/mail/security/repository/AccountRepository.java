package com.hucet.mail.security.repository;


import com.hucet.mail.security.domain.Account;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * Created by taesu on 2017-02-18.
 */
public interface AccountRepository extends Repository<Account, Long> {
    Account save(Account account);

    Optional<Account> findByUserName(String userName);
}
