package com.hucet.oauth2.service;

import com.hucet.oauth2.domain.OAuthAccount;
import com.hucet.oauth2.domain.Role;
import com.hucet.oauth2.enums.RoleType;
import com.hucet.oauth2.repository.OAuthAccountDao;
import com.hucet.oauth2.repository.RoleDao;
import com.hucet.rabbitmq.dto.OAuth2UserDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface RoleService {
    Optional<Role> getRoleType(RoleType roleType);
    @Service
    @Transactional
    @Slf4j
    class Impl implements RoleService {

        @Autowired
        RoleDao roleDao;

        @Override
        public Optional<Role> getRoleType(RoleType roleType) {
            return roleDao.findByRoleType(roleType);
        }
    }
}
