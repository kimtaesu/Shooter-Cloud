package com.hucet.userservice.service;

import com.hucet.common.exception.client.DuplicatedFieldException;
import com.hucet.userservice.domain.Account;
import com.hucet.userservice.dto.AccountDto;
import com.hucet.userservice.repository.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by taesu on 2017-01-22.
 */
public interface AccountService {

    Account newUser(AccountDto.ApplicationRequest applicationRequest);

    @Service
    @Transactional
    @Slf4j
    class AccountServiceImpl implements AccountService {
        @Autowired
        AccountDao accountDao;

        @Autowired
        ModelMapper modelMapper;

        @Autowired
        OAuth2UserService oAuth2UserService;

        @Override
        public Account newUser(AccountDto.ApplicationRequest applicationRequest) {
            boolean exist = accountDao.findByUserName(applicationRequest.getUserName())
                    .isPresent();
            if (exist) {
                // TODO EXCEPTION
                throw new DuplicatedFieldException("동일한 사용자명이 존재합니다.");
            }

            exist = accountDao.findByUserEmail(applicationRequest.getUserEmail())
                    .isPresent();
            if (exist) {
                // TODO EXCEPTION
                throw new DuplicatedFieldException("동일한 이메일이 존재합니다.");
            }

            Account account = modelMapper.map(applicationRequest, Account.class);
            account = accountDao.save(account);

            oAuth2UserService.syncOAuthUserAdded(applicationRequest);

            return account;
        }
    }

}
