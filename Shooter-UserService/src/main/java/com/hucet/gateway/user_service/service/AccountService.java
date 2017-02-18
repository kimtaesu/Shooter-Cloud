package com.hucet.gateway.user_service.service;

import com.hucet.gateway.user_service.domain.Account;
import com.hucet.gateway.user_service.dto.AccountDto;
import com.hucet.gateway.user_service.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Slf4j
@Service
public class AccountService {
    @Autowired
    AccountRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public Long newAccount(AccountDto dto) {
        // TODO Exist User
        Account account = modelMapper.map(dto, Account.class);
        return repository.save(account).getId();
    }

    public Account getUser(String userName) {
        Optional<Account> accountOptional = repository.findByUserName(userName);
        if (accountOptional.isPresent())
        {
            return accountOptional.get();
        } else {
            // TODO THROW Catch
            throw new RuntimeException("can't find the account");
        }
    }
}
