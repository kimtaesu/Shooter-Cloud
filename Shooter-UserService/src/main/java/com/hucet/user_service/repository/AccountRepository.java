package com.hucet.user_service.repository;

import com.hucet.user_service.domain.Account;
import org.springframework.data.repository.Repository;

/**
 * Created by taesu on 2017-02-18.
 */
public interface AccountRepository extends Repository<Account, Long> {
    Account save(Account account);
}
