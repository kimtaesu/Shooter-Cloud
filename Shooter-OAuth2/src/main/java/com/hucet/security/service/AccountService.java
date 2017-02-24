package com.hucet.security.service;

import com.hucet.security.domain.Account;
import com.hucet.security.domain.Role;
import com.hucet.security.dto.AccountDto;
import com.hucet.security.enums.RoleType;
import com.hucet.security.repository.AccountRepository;
import com.hucet.security.repository.RoleRepository;
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
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ModelMapper modelMapper;

    public Long newAccount(AccountDto dto) {
        // TODO Exist User
        Account account = modelMapper.map(dto, Account.class);
        account.addRole(getDefaultRole());
        return accountRepository.save(account).getId();
    }

    public Account getUser(String userName) {
        Optional<Account> accountOptional = accountRepository.findByUserName(userName);
        if (accountOptional.isPresent()) {
            return accountOptional.get();
        } else {
            // TODO THROW Catch
            throw new RuntimeException("can't find the account");
        }
    }

    private Role getDefaultRole() {
        Optional<Role> defualtRole = roleRepository.findByRoleType(RoleType.ROLE_USER);
        if (defualtRole.isPresent()) {
            return defualtRole.get();
        }
        return roleRepository.save(RoleType.ROLE_USER);
    }
}
