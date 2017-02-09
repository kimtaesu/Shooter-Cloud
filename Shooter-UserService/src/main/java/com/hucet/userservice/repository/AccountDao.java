package com.hucet.userservice.repository;


import com.hucet.userservice.domain.Account;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * Created by taesu on 2017-01-21.
 */
public interface AccountDao extends Repository<Account, Long> {
    Account save(Account newAccount);

    Optional<Account> findByUserName(String userName);

    Optional<Account> findByUserEmail(String userEmail);

}
