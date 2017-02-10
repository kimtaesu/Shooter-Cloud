package com.hucet.oauth2.service;

import com.hucet.oauth2.domain.OAuthAccount;
import com.hucet.oauth2.enums.RoleType;
import com.hucet.oauth2.repository.OAuthAccountDao;
import com.hucet.rabbitmq.dto.OAuth2UserDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface OAuthUserService {
    Boolean addOAuth2User(OAuth2UserDto dto);

    @Service
    @Transactional
    @Slf4j
    class Impl implements OAuthUserService {

        @Autowired
        OAuthAccountDao oAuthAccountDao;

        @Autowired
        RoleService roleService;

        @Autowired
        ModelMapper modelMapper;

        @Override
        public Boolean addOAuth2User(OAuth2UserDto dto) {
            if (oAuthAccountDao.findByUserName(dto.getUserName()).isPresent()) {
                // if the user exist, saving skip
                return true;
            }
            OAuthAccount account = modelMapper.map(dto, OAuthAccount.class);
            if (roleService.getRoleType(RoleType.ROLE_USER).isPresent()) {
                oAuthAccountDao.save(account);
            }
            return true;
        }
    }
}
