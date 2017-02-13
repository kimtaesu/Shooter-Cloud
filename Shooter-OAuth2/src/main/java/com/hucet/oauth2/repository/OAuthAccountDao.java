package com.hucet.oauth2.repository;


import com.hucet.oauth2.domain.OAuth2Account;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface OAuthAccountDao extends Repository<OAuth2Account, Long> {

    Optional<OAuth2Account> findByUserName(String userName);

    OAuth2Account save(OAuth2Account oauth2Account);
}
