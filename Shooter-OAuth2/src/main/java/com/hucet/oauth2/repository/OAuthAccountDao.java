package com.hucet.oauth2.repository;


import com.hucet.oauth2.domain.OAuthAccount;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface OAuthAccountDao extends Repository<OAuthAccount, Long> {

    Optional<OAuthAccount> findByUserName(String userName);

    OAuthAccount save(OAuthAccount oauthAccount);
}
