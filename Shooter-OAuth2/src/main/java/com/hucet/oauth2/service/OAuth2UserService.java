package com.hucet.oauth2.service;

import com.hucet.oauth2.domain.OAuth2Account;
import com.hucet.oauth2.dto.AccountDto;
import com.hucet.oauth2.enums.RoleType;
import com.hucet.oauth2.repository.OAuthAccountDao;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by taesu on 2017-02-14.
 */
public interface OAuth2UserService {
    Boolean addOAuth2User(AccountDto dto);

    @Service
    @Transactional
    @Slf4j
    class Impl implements OAuth2UserService {

        @Autowired
        OAuthAccountDao oAuthAccountDao;

        @Autowired
        RoleService roleService;

        @Autowired
        ModelMapper modelMapper;

        @Override
        public Boolean addOAuth2User(AccountDto dto) {
            if (oAuthAccountDao.findByUserName(dto.getUserName()).isPresent()) {
            }
            OAuth2Account account = modelMapper.map(dto, OAuth2Account.class);
            if (roleService.getRoleType(RoleType.ROLE_USER).isPresent()) {
                oAuthAccountDao.save(account);
            }
            return true;
        }
    }
}
