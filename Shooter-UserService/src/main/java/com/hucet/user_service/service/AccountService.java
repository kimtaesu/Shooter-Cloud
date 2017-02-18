package com.hucet.user_service.service;

import com.hucet.user_service.domain.Account;
import com.hucet.user_service.dto.AccountDto;
import com.hucet.user_service.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Slf4j
@Service
public class AccountService {
    @Autowired
    AccountRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public Long newAccount(AccountDto dto) {
        Account account = modelMapper.map(dto, Account.class);
        return repository.save(account).getId();
    }
}
